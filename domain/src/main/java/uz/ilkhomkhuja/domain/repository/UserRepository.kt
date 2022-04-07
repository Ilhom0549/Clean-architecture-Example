package uz.ilkhomkhuja.domain.repository

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import uz.ilkhomkhuja.domain.models.GithubUser

interface UserRepository {
    fun getUsers(): Flow<List<GithubUser>>
}