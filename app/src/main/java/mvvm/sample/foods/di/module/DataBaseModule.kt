package mvvm.sample.foods.di.module

import android.app.Application
import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import mvvm.sample.foods.data.db.AppDatabase
import mvvm.sample.foods.data.db.FoodDao
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(application: Application): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, AppDatabase.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideUserDao(appDataBase: AppDatabase): FoodDao {
        return appDataBase.foodDao()
    }
}