package uz.ilkhomkhuja.cleanarchitectureexample.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uz.ilkhomkhuja.cleanarchitectureexample.viewmodel.UserViewModel
import uz.ilkhomkhuja.cleanarchitectureexample.viewmodel.ViewModelFactory
import uz.ilkhomkhuja.cleanarchitectureexample.viewmodel.ViewModelKey

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    fun bindUserViewModel(userViewModel: UserViewModel): ViewModel
}