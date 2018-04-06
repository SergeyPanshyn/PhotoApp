package com.example.photoapp.presentation.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import com.example.photoapp.PhotoApplication
import com.example.photoapp.R
import com.example.photoapp.data.api.models.PhotoItemResponse
import com.example.photoapp.presentation.main.di.MainModule
import com.example.photoapp.presentation.photo.PhotoItemView
import com.example.photoapp.presentation.search.SearchFragment
import com.example.photoapp.presentation.search.di.SearchModule
import javax.inject.Inject


/**
 * Created by Sergey Panshyn on 03.11.2017.
 */
class MainActivity: AppCompatActivity(), MainPresenter.MainView, SearchFragment.SearchFragmentListener {

    companion object {
        const val SEARCH_FRAGMENT_TAG = "SEARCH_FRAGMENT_TAG"
    }

    val featuredComponent by lazy { PhotoApplication.appComponent?.getFeaturedComponent(SearchModule()) }
    val mainComponent by lazy { PhotoApplication.appComponent?.getMainComponent(MainModule()) }


    @Inject
    lateinit var mainPresenter: MainPresenter<MainPresenter.MainView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        ButterKnife.bind(this)

        daggerInit()

        replaceFragment(SearchFragment(), SEARCH_FRAGMENT_TAG)
    }

    private fun daggerInit() {
        mainComponent?.inject(this)
        mainPresenter.setView(this)
    }

    override fun onPhotoItemClick(photoItemResponse: PhotoItemResponse) {
        val photoItemView = PhotoItemView()
        photoItemView.showColorPickerView(this, photoItemResponse)
    }

    private fun replaceFragment(fragment: Fragment, tag: String, addToBackStack: Boolean = false) {
        val transaction = supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_fl, fragment, tag)

        if (addToBackStack) transaction.addToBackStack(null)

        transaction.commit()
    }
}