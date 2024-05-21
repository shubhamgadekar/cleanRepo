package com.alpha.cleanRepo

import android.app.Application
import com.alpha.cleanRepo.di.ApplicationComponent
import com.alpha.cleanRepo.di.DaggerApplicationComponent


class MyApplication : Application() {

    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder().applicationContext(applicationContext).build()
    }

}