package uz.ilkhomkhuja.cleanarchitectureexample.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.ilkhomkhuja.cleanarchitectureexample.R
import uz.ilkhomkhuja.cleanarchitectureexample.application.App
import uz.ilkhomkhuja.cleanarchitectureexample.utils.UserResource
import uz.ilkhomkhuja.cleanarchitectureexample.viewmodel.UserViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: UserViewModel by viewModels { factory }
    private val tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.appComponent.inject(this)
        lifecycleScope.launch {
            viewModel.getUsers()
                .collect {
                    when (it) {
                        is UserResource.Loading -> {

                        }
                        is UserResource.Success -> {
                            Log.d(tag, "onCreate: ${it.list}")
                        }
                        is UserResource.Error -> {
                            Toast.makeText(this@MainActivity, it.msg, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
        }
    }
}