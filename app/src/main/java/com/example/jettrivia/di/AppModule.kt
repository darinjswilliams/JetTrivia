package com.example.jettrivia.di

import com.example.jettrivia.model.Question
import com.example.jettrivia.network.QuestionApi
import com.example.jettrivia.repository.QuestionRepository
import com.example.jettrivia.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //All of injection is done hilt and dagger in the background

    //RetroFit Provider
    @Singleton
    @Provides
    fun provideQuestionApi(): QuestionApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionApi::class.java)
    }

    //QuestionAPI we need to inject
    @Singleton
    @Provides
    fun providesQuestionRepository(api: QuestionApi) = QuestionRepository(api)
}