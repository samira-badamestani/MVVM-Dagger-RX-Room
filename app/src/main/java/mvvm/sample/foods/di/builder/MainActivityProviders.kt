package mvvm.sample.foods.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mvvm.sample.foods.ui.HomeFragment

@Module
abstract class MainActivityProviders{
    @ContributesAndroidInjector
    abstract fun provideHomeFragment(): HomeFragment

}