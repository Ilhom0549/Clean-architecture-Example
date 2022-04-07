package uz.ilkhomkhuja.cleanarchitectureexample.di.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import uz.ilkhomkhuja.data.network.ApiService
import uz.ilkhomkhuja.data.repository.UserRepositoryImpl
import uz.ilkhomkhuja.domain.repository.UserRepository
import javax.inject.Singleton

@Module(includes = [DataModule.BindModule::class])
class DataModule {

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Module
    abstract class BindModule {
        @Binds
        abstract fun bindApiRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
    }
}