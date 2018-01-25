package com.example.photoapp.presentation.search

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import butterknife.BindView
import butterknife.ButterKnife
import com.example.photoapp.R
import com.example.photoapp.data.api.models.PhotoItem
import com.example.photoapp.data.api.models.PhotoResponse
import com.example.photoapp.presentation.main.MainActivity
import com.example.photoapp.presentation.search.adapter.PhotoAdapter
import javax.inject.Inject

/**
 * Created by Sergey Panshyn on 03.11.2017.
 */
class SearchFragment : Fragment(), SearchPresenter.FeaturedView {

    @BindView(R.id.featured_rv)
    lateinit var featuredRv: RecyclerView

    @BindView(R.id.pull_to_refresh_featured)
    lateinit var pullToRefreshFeatured: SwipeRefreshLayout

    @BindView(R.id.featured_progress_bar)
    lateinit var featuredProgressBar: ProgressBar

    @BindView(R.id.featured_fab)
    lateinit var featuredFab: FloatingActionButton

    @Inject
    lateinit var searchPresenter: SearchPresenter<SearchPresenter.FeaturedView>

    private var photoAdapter: PhotoAdapter? = null

    var localOffset = 0

    var couldLoadMore = true

    private var recycleAdapterList = ArrayList<PhotoItem>()

    var layoutManager: LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragment = inflater.inflate(R.layout.fragment_featured, container, false)

        ButterKnife.bind(this, fragment)

        daggerInit()

        initRecyclerView()

        pullToRefreshFeatured.setOnRefreshListener {
            cancelAllVariables()
            initRecyclerView()
            callGetFeaturedVideos()
        }

        featuredFab.setOnClickListener{
            featuredRv.smoothScrollToPosition(0)
        }

        return fragment
    }

    private fun daggerInit() {
        (activity as MainActivity).featuredComponent?.inject(this)
        searchPresenter.setView(this)
    }

    override fun showPhotos(photoResponse: PhotoResponse) {
        recycleAdapterList.addAll(photoResponse.photos.photo)
        featuredRv.adapter.notifyDataSetChanged()
        setLoadedView()
    }

    private fun callGetFeaturedVideos() {
        couldLoadMore = false
        searchPresenter.getPhotos("dogs")
    }

    private fun initRecyclerView() {
        layoutManager = LinearLayoutManager(context)
        featuredRv.layoutManager = layoutManager

        photoAdapter = PhotoAdapter(context!!, recycleAdapterList)
        featuredRv.adapter = photoAdapter

        featuredRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    featuredFab.hide()
                    if (!recyclerView!!.canScrollVertically(RecyclerView.FOCUS_DOWN)) {
                        if (couldLoadMore) {
                            localOffset += 20
                            featuredProgressBar.visibility = View.VISIBLE
                            callGetFeaturedVideos()
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