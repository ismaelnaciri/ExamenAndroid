package cat.insvidreres.inf.examenandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import cat.insvidreres.inf.examenandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view_tag) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNavigationView = binding.bottomMenuView

        setupWithNavController(bottomNavigationView, navController)
    }
}