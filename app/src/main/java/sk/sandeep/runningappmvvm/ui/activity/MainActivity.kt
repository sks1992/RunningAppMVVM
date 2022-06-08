package sk.sandeep.runningappmvvm.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import sk.sandeep.runningappmvvm.R
import sk.sandeep.runningappmvvm.data.local.RunDAO
import sk.sandeep.runningappmvvm.databinding.ActivityMainBinding
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var runDao: RunDAO
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //to attach customToolbar
        setSupportActionBar(binding.toolbar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.findNavController()
        /**
        For Adding BottomNavigation functionality
         * */
        binding.bottomNavigationView.setupWithNavController(navController)

        navHostFragment.findNavController().addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.settingsFragment, R.id.runFragment, R.id.statisticFragment ->
                    binding.bottomNavigationView.visibility = View.VISIBLE

                else -> binding.bottomNavigationView.visibility = View.GONE
            }
        }
    }
}