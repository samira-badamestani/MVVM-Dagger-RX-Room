package mvvm.sample.foods.di.builder

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module(includes = [
    (AppViewModelBuilder::class)
])
abstract class ViewModelBuilder {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}