package com.example.photoapp.presentation.search.di

import com.example.photoapp.presentation.di.PerActivity
import com.example.photoapp.presentation.search.SearchFragment
import dagger.Subcomponent

/**
 * Created by Sergey Panshyn on 03.11.2017.
 */
@PerActivity
@Subcomponent(modules = arrayOf(SearchModule::class))
interface SearchComponent {

    fun inject(searchFragment: SearchFragment)

}