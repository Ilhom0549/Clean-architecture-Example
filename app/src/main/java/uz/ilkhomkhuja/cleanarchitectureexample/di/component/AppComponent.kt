package uz.ilkhomkhuja.cleanarchitectureexample.di.component

import dagger.BindsInstance
import dagger.Component
import uz.ilkhomkhuja.cleanarchitectureexample.application.App
import uz.ilkhomkhuja.cleanarchitectureexample.di.module.ApplicationModule
import uz.ilkhomkhuja.cleanarchitectureexample.di.module.DataModule
import uz.ilkhomkhuja.cleanarchitectureexample.di.module.ViewModelModule
import uz.ilkhomkhuja.cleanarchitectureexample.presentation.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, DataModule::class, ViewModelModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): AppComponent
    }
    fun inject(app: App)
    fun inject(mainActivity: MainActivity)

}