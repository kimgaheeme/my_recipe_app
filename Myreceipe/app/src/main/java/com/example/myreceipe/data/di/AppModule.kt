package com.example.myreceipe.data.di

import android.app.Application
import androidx.room.Room
import com.example.myreceipe.data.data_source.PostDatabase
import com.example.myreceipe.data.repository.IngredientRepositoryImpl
import com.example.myreceipe.data.repository.IngredientUseRepositoryImpl
import com.example.myreceipe.data.repository.PostRepositoryImpl
import com.example.myreceipe.domain.usecase.post.AddPost
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
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providePostRepository(db: PostDatabase) : PostRepository {
        return PostRepositoryImpl(db.postDao)
    }

    @Provides
    @Singleton
    fun providePostUseCase(repository: PostRepository) : PostUseCase {
        return PostUseCase(
            getPost = GetPostUseCase(repository),
            deletePost = DeletePostUseCase(repository),
            addPost = AddPost(repository),
            getPostDetail = GetPostDetail(repository)
        )
    }


    @Provides
    @Singleton
    fun provideIngredientRepository(db: PostDatabase) : IngredientRepository {
        return IngredientRepositoryImpl(db.ingredientDao)
    }

    @Provides
    @Singleton
    fun provideIngredientUseCase(repository: IngredientRepository, repository2: IngredientUseRepository) : IngredientUseCase {
        return IngredientUseCase(
            addIngredient = AddIngredientUseCase(repository),
            addIngredientUse = AddIngredientUseUseCase(repository2),
            deleteIngredient = DeleteIngredientUseCase(repository),
            getIngredientUseCase = GetIngredientUseCase(repository)
        )
    }


    @Provides
    @Singleton
    fun provideIngredientUseRepository(db: PostDatabase) : IngredientUseRepository {
        return IngredientUseRepositoryImpl(db.ingredientUseDao)
    }


}