package com.mita.gamebuddymobile.api


import com.mita.gamebuddymobile.MessageResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path


interface ApiService {
    @POST("login")
    fun login(@Body login: Login): Call<LoginResponse>

    @POST("register")
    fun register(@Body user: User): Call<User>

    @GET("list")
    fun getUser(): Call<List<UserDataClass>>

    @GET("conversations/{conversationId}/messages")
    fun getMessages(@Path("conversationId") conversationId: String, @Header("Authorization") authorization: String): Call<MessageResponse>

    @POST("conversations/{conversationId}/messages")
    fun sendMessage(@Path("conversationId") conversationId: String, @Header("Authorization") authorization: String, @Body request: Map<String, String>): Call<Message>

    @GET("conversations/{conversationId}")
    fun getConversation(@Path("conversationId") conversationId: String, @Header("Authorization") authorization: String): Call<ConversationResponse>

    @POST("conversations/{conversationId}/message")
    fun postConversation(@Path("conversationId") conversationId: String, @Header("Authorization") authorization: String): Call<ConversationResponse>

}
