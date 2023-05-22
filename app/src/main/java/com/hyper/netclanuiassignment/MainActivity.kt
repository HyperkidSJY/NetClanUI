package com.hyper.netclanuiassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.hyper.netclanuiassignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(Refine())

        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.refine -> replaceFragment(Refine())
                R.id.explore -> replaceFragment(Explore())
                R.id.network -> replaceFragment(Network())
                R.id.chat -> replaceFragment(Chats())
                R.id.contacts -> replaceFragment(Contacts())

                else ->{
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.detach(fragment)
        fragmentTransaction.attach(fragment)
        fragmentTransaction.commit()
    }
}