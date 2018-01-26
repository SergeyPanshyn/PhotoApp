package com.example.photoapp.presentation.search

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import butterknife.BindView
import butterknife.ButterKnife
import com.example.photoapp.R
import com.example.photoapp.data.api.models.PhotoItem
import com.example.photoapp.data.api.models.PhotoResponse
import com.example.photoapp.presentation.main.MainActivity
import com.example.photoapp.presentation.search.adapter.PhotoAdapter
import com.example.photoapp.presentation.search.adapter_favor.FavorAdapter
import javax.inject.Inject



/**
 * Created by Sergey Panshyn on 03.11.2017.
 */
class SearchFragment : Fragment(), SearchPresenter.FeaturedView {

    @BindView(R.id.photos_rv)
    lateinit var photosRv: RecyclerView

    @BindView(R.id.favor_tags_rv)
    lateinit var favorTagsRv: RecyclerView

    @BindView(R.id.pull_to_refresh_featured)
    lateinit var pullToRefreshFeatured: SwipeRefreshLayout

    @BindView(R.id.featured_progress_bar)
    lateinit var featuredProgressBar: ProgressBar

    @BindView(R.id.featured_fab)
    lateinit var featuredFab: FloatingActionButton

    @BindView(R.id.search_et)
    lateinit var searchEt: EditText

    @Inject
    lateinit var searchPresenter: SearchPresenter<SearchPresenter.FeaturedView>

    private var photoAdapter: PhotoAdapter? = null

    var localOffset = 0

    var localTag = "interesting"

    var couldLoadMore = true

    private var recycleAdapterList = ArrayList<PhotoItem>()

    var layoutManager: LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragment = inflater.inflate(R.layout.fragment_search, container, false)

        ButterKnife.bind(this, fragment)

        daggerInit()

        initPhotosRecyclerView()

        initFavoritesRecyclerView()

        searchEt.setOnEditorActionListener(object : OnEditorActionListener {
            override fun onEditorAction(v: TextView, actionId: Int, event: KeyEvent?): Boolean {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    localTag = searchEt.text.toString()
                    cancelAllVariables()
                    initPhotosRecyclerView()
                    callGetPhotos()
                    return true
                }
                return false
            }
        })

        pullToRefreshFeatured.setOnRefreshListener {
            cancelAllVariables()
            initPhotosRecyclerView()
            callGetPhotos()
        }

        featuredFab.setOnClickListener{
            photosRv.smoothScrollToPosition(0)
        }

        return fragment
    }

    private fun daggerInit() {
        (activity as MainActivity).featuredComponent?.inject(this)
        searchPresenter.setView(this)
        callGetPhotos()
    }

    override fun showPhotos(photoResponse: PhotoResponse) {
        recycleAdapterList.addAll(photoResponse.photos.photo)
        photosRv.adapter.notifyDataSetChanged()
        setLoadedView()
    }

    private fun callGetPhotos() {
        couldLoadMore = false
        searchPresenter.getPhotos(localTag, localOffset)
    }

    private fun initFavoritesRecyclerView() {
        val list = listOf("dogs", "cat", "nature", "animals", "anime", "cooking")
        favorTagsRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        favorTagsRv.adapter = FavorAdapter(context, list,
                View.OnClickListener {
                    localTag = list.get(it.tag as Int)
                    cancelAllVariables()
                    initPhotosRecyclerView()
                    callGetPhotos()
                }
        )
    }

    private fun initPhotosRecyclerView() {
        layoutManager = LinearLayoutManager(context)
        photosRv.layoutManager = layoutManager

        photoAdapter = PhotoAdapter(context!!, recycleAdapterList)
        photosRv.adapter = photoAdapter

        photosRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    featuredFab.hide()
                    if (!recyclerView!!.canScrollVertically(RecyclerView.FOCUS_DOWN)) {
                        if (couldLoadMore) {
                            localOffset += 1
//                            featuredProgressBar.visibility = View.VISIBLE
                            callGetPhotos()
                        }
                    }
                } else if (dy<0) {
                    featuredFab.show()
                    if (layoutManager!!.findFirstCompletelyVisibleItemPosition() == 0) {
                        featuredFab.hide()
                    }
                }
            }
        })
    }

    private fun setLoadedView() {
        pullToRefreshFeatured.isRefreshing = false
        couldLoadMore = true
        featuredProgressBar.visibility = View.GONE
    }

    private fun cancelAllVariables() {
        localOffset = 0
        recycleAdapterList = ArrayList<PhotoItem>()
    }
}