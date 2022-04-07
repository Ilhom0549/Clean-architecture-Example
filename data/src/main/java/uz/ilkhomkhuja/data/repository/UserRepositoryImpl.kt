package uz.ilkhomkhuja.data.repository

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import uz.ilkhomkhuja.data.network.ApiService
import uz.ilkhomkhuja.domain.models.GithubUser
import uz.ilkhomkhuja.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val apiService: ApiService) : UserRepository {
    override fun getUsers(): Flow<List<GithubUser>> {
        return apiService.getUsers()
    }
}