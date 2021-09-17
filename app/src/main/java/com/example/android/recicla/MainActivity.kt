package com.example.android.recicla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.android.recicla.fragments.ContaFragment
import com.example.android.recicla.fragments.MapsFragment
import com.example.android.recicla.fragments.TrocasFragment
import kotlinx.android.synthetic.main.activity_navigation.*

class MainActivity : AppCompatActivity() {

    private val trocasFragment = TrocasFragment()
    private val mapsFragment = MapsFragment()
    private val contaFragment = ContaFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        replaceFragment(trocasFragment)

        nav_view.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.navigation_trocas -> replaceFragment(trocasFragment)
                R.id.navigation_lugares -> replaceFragment(mapsFragment)
                R.id.navigation_perfil -> replaceFragment(contaFragment)

            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment !=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }

    }
