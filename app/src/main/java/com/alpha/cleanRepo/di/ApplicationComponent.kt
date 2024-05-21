package com.alpha.cleanRepo.di

import android.content.Context
import com.alpha.cleanRepo.activity.HomeScreenActivity
import com.alpha.cleanRepo.fragments.HomeFragment
import com.alpha.cleanRepo.fragments.SecondFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApiModule::class, DatabaseModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Bbuilder {
        @BindsInstance
        fun applicationContext(context: Context): Bbuilder
        fun build(): ApplicationComponent
    }

    fun inject(homeScreenActivity: HomeScreenActivity)

    fun inject(homeFragment: HomeFragment)

    fun inject(secondFragment: SecondFragment)
}