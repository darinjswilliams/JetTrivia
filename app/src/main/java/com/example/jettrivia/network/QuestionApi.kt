package com.example.jettrivia.network


import com.example.jettrivia.model.Question
import com.example.jettrivia.util.Constants.WORLD_URI
import retrofit2.http.GET
import javax.inject.Singleton


@Singleton
interface QuestionApi {
    @GET(WORLD_URI)
    suspend fun getAllQuestions(): Question
}