package com.example.myreceipe.data.di

import android.app.Application
import androidx.room.Room
import com.example.myreceipe.data.data_source.IngredientDatabase
import com.example.myreceipe.data.data_source.IngredientUseDatabase
import com.example.myreceipe.data.data_source.PostDatabase
import com.example.myreceipe.data.repository.IngredientRepositoryImpl
import com.example.myreceipe.data.repository.IngredientUseRepositoryImpl
import com.example.myreceipe.data.repository.PostRepositoryImpl
import com.example.myreceipe.domain.model.Post
import com.example.myreceipe.domain.repository.AddPost
import com.example.myreceipe.domain.repository.IngredientRepository
import com.example.myreceipe.domain.repository.IngredientUseRepository
import com.example.myreceipe.domain.repository.PostRepository
import com.example.myreceipe.domain.usecase.post.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePostDatabase(app: Application): PostDatabase {
        return Room.databaseBuilder(
            app,
            PostDatabase::class.java,
            PostDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providePostRepository(db: PostDatabase) : PostRepository {
        return PostRepositoryImpl(db.PostDao)
    }

    @Provides
    @Singleton
    fun providePostUseCase(repository: PostRepository) : PostUseCase {
        return PostUseCase(
            getPost = GetPostUseCase(repository),
            deletePost = DeletePostUseCase(repository),
            addPost = AddPost(repository)
        )
    }

    @Provides
    @Singleton
    fun provideIngredientDatabase(app: Application): IngredientDatabase {
        return Room.databaseBuilder(
            app,
            IngredientDatabase::class.java,
            IngredientDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideIngredientRepository(db: IngredientDatabase) : IngredientRepository {
        return IngredientRepositoryImpl(db.IngredientDao)
    }

    @Provides
    @Singleton
    fun provideIngredientUseCase(repository: IngredientRepository) : IngredientUseCase {
        return IngredientUseCase(
            getIngredient = GetIngredientUseCase(repository),
            deleteIngredient = DeleteIngredientUseCase(repository)
        )
    }

    @Provides
    @Singleton
    fun provideIngredientUseDatabase(app: Application): IngredientUseDatabase {
        return Room.databaseBuilder(
            app,
            IngredientUseDatabase::class.java,
            IngredientUseDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideIngredientUseRepository(db: IngredientUseDatabase) : IngredientUseRepository {
        return IngredientUseRepositoryImpl(db.IngredientUseDao)
    }


}