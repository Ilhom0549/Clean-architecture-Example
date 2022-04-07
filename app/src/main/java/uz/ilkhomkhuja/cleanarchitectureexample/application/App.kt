package uz.ilkhomkhuja.cleanarchitectureexample.application

import android.app.Application
import uz.ilkhomkhuja.cleanarchitectureexample.di.component.AppComponent
import uz.ilkhomkhuja.cleanarchitectureexample.di.component.DaggerAppComponent
import javax.inject.Inject

class App @Inject constructor() : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .factory()
            .create(this)

        appComponent.inject(this)
    }
}