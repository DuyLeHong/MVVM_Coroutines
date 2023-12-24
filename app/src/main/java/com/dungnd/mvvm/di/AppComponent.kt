package com.dungnd.mvvm.di

import android.app.Application
import com.dungnd.mvvm.BaseApp
import com.dungnd.mvvm.di.module.ActivityBindingModule
import com.dungnd.mvvm.di.module.AppModule
import com.dungnd.mvvm.di.module.DatabaseModule
import com.dungnd.mvvm.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, AppModule::class, AndroidSupportInjectionModule::class, ActivityBindingModule::class, DatabaseModule::class])
interface AppComponent : AndroidInjector<BaseApp> {

    override fun inject(application: BaseApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}