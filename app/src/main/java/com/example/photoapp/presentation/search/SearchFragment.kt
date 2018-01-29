package com.example.photoapp.presentation.search

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
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
class SearchFragment : Fragment(), SearchPresenter.FeaturedView, OnScrollListener.OnScrollListenerCallback {
    override fun onScrollingDown() {
        featuredFab.hide()

//        if (layoutManager!!.findFirstCompletelyVisibleItemPosition() != 0) {
//            favorTagsRv.visibility = View.GONE
//        }
    }

    override fun onScrollingUp() {
        featuredFab.show()
        if (layoutManager!!.findFirstCompletelyVisibleItemPosition() == 0) {
            featuredFab.hide()
//            favorTagsRv.visibility = View.VISIBLE
        }
    }

    override fun onScrolledTillTheEnd() {
        if (couldLoadMore) {
            localOffset += 1
            callGetPhotos()
        }
    }

    @BindView(R.id.photos_rv)
    lateinit var photosRv: RecyclerView

    @BindView(R.id.favor_tags_rv)
    lateinit var favorTagsRv: RecyclerView

    @BindView(R.id.featured_progress_bar)
    lateinit var featuredProgressBar: ProgressBar

    @BindView(R.id.featured_fab)
    lateinit var featuredFab: FloatingActionButton

    @BindView(R.id.search_et)
    lateinit var searchEt: EditText

    @Inject
    lateinit var searchPresenter: SearchPresenter<SearchPresenter.FeaturedView>

    private var photoAdapter: PhotoAdapter? = null

    var localOffset = 1

    var localTag = "interesting"

    var couldLoadMore = true

    private var recycleAdapterList = ArrayList<PhotoItem>()

    var layoutManager: LinearLayoutManager? = null

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
                    callGetPhotos()
                    return true
                }
                return false
            }
        })

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

        photosRv.addOnScrollListener(OnScrollListener(this))
    }

    private fun setLoadedView() {
        couldLoadMore = true
        featuredProgressBar.visibility = View.GONE
    }

    private fun cancelAllVariables() {
        localOffset = 0
        recycleAdapterList = ArrayList<PhotoItem>()
    }
}