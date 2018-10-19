package mvvm.sample.foods.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import mvvm.sample.foods.di.builder.ViewModelBuilder
import javax.inject.Singleton

@Module(includes = [ViewModelBuilder::class])
class ContextModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }
}