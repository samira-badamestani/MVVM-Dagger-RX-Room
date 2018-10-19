package mvvm.sample.foods.di.builder

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import mvvm.sample.foods.di.qualifier.ViewModelKey
import mvvm.sample.foods.ui.HomeViewModel

@Module
abstract class AppViewModelBuilder {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel



}