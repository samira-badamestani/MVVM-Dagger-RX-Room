package mvvm.sample.foods.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import mvvm.sample.foods.core.App
import mvvm.sample.foods.di.builder.ActivityBuilder
import mvvm.sample.foods.di.module.ContextModule
import mvvm.sample.foods.di.module.DataBaseModule
import mvvm.sample.foods.di.module.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, NetworkModule::class,  ActivityBuilder::class,
     DataBaseModule::class, ContextModule::class])
interface CoreComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): CoreComponent
    }


}