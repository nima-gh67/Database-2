package khoshi.amin.sqlite.view.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import khoshi.amin.sqlite.App
import khoshi.amin.sqlite.model.dao.DatabaseDao
import khoshi.amin.sqlite.model.repository.DbRepository
import khoshi.amin.sqlite.model.repository.DbRepositoryImpl
import khoshi.amin.sqlite.model.usecase.MainUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainDi {

    @Provides
    @Singleton
    fun provideDd(app: Application): DatabaseDao.Dao {
        return Room.databaseBuilder(
            app.applicationContext, DatabaseDao::class.java, App.DATABASE_NAME
        )
            .build()
            .dao
    }

    @Provides
    @Singleton
    fun provideDbRepository(dao: DatabaseDao.Dao): DbRepository {
        return DbRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: DbRepository): MainUseCase {
        return MainUseCase(repository)
    }
}