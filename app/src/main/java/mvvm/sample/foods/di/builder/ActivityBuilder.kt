package mvvm.sample.foods.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mvvm.sample.foods.ui.MainActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityProviders::class])
    abstract fun bindMainActivity(): MainActivity
}