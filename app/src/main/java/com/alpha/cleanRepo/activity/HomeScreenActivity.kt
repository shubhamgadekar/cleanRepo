package com.alpha.cleanRepo.activity

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.alpha.cleanRepo.MyApplication
import com.alpha.cleanRepo.R
import com.alpha.cleanRepo.di.ApplicationComponent
import com.alpha.cleanRepo.viewModel.HomeScreenViewModel
import javax.inject.Inject

class HomeScreenActivity : AppCompatActivity() {

    val appComponent: ApplicationComponent by lazy {
        (application as MyApplication).appComponent
    }
    lateinit var navController: NavController

    @Inject
    lateinit var viewModel: HomeScreenViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        setContentView(R.layout.activity_home_screen)

        navController = findNavController(R.id.nav_host_fragment)
        navController.navigate(R.id.home_fragment)




    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (navController.currentDestination?.id == R.id.home_fragment) {
            showExitConfirmationDialog()
        } else {
            super.onBackPressed()
        }
    }

    private fun showExitConfirmationDialog() {
        AlertDialog.Builder(this)
            .setTitle("Exit Confirmation")
            .setMessage("Are you sure you want to exit the app?")
            .setPositiveButton("Yes") { _, _ ->
                finish()
            }
            .setNegativeButton("No", null)
            .show()
    }

    fun replaceFragment(fragment: Int, arguments: Bundle) {
        navController.navigate(fragment, arguments)
    }
}