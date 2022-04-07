package uz.ilkhomkhuja.data.network

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import uz.ilkhomkhuja.domain.models.GithubUser

interface ApiService {

    @GET("users")
    fun getUsers(): Flow<List<GithubUser>>

}