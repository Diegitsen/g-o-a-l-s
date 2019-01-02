package com.example.diego.mygoals

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar

class MainActivity : AppCompatActivity() {

    lateinit var toolbar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //instanciamos el bottomNav
        toolbar = supportActionBar!!
        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_checked -> {

                toolbar.title = "Checked"
                val checkedFragment = CheckedFragment.newInstance()
                openFragment(checkedFragment)

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_goal -> {

                toolbar.title = "Goals"
                val goalFragment = GoalFragment.newInstance()
                openFragment(goalFragment)

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_stats -> {

                toolbar.title = "Stats"
                val statsFragment = StatsFragment.newInstance()
                openFragment(statsFragment)

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
