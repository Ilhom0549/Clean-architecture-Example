package uz.ilkhomkhuja.cleanarchitectureexample.utils

import uz.ilkhomkhuja.domain.models.GithubUser

sealed class UserResource {

    object Loading : UserResource()

    data class Success(val list: List<GithubUser>?) : UserResource()

    data class Error(val msg: String?) : UserResource()
}