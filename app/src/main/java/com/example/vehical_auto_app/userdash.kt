package com.example.vehical_auto_app

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class userdash : AppCompatActivity() {
    var sharedpreferences: SharedPreferences? = null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_userdash)





        val bottom = findViewById<BottomNavigationView>(R.id.bottom)

        bottom.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {


                R.id.shop ->
                {
                    val i = Intent(applicationContext, createprofile::class.java)
                    startActivity(i)
                    true
                }

                R.id.showtask ->
                {
                    val i = Intent(applicationContext,location::class.java)
                    startActivity(i)
                    true
                }

                R.id.feedback ->
                {
                    val i = Intent(applicationContext, Showprofile::class.java)
                    startActivity(i)
                    true
                }

                R.id.guide ->
                {
                    val i = Intent(applicationContext,guide::class.java)
                    startActivity(i)
                    true
                }

                R.id.chatbot ->
                {
                    val i = Intent(applicationContext,chatbot::class.java)
                    startActivity(i)
                    true
                }


                else -> {false}
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {


        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {



            R.id.logout -> {
                val intent = Intent(applicationContext,MainActivity::class.java)
                startActivity(intent)

//                auth.signOut()
//                Firebase.auth.signOut()
//                startActivity(Intent(this,login::class.java))
//                finish()

            }
            R.id.history -> {
                val intent = Intent(applicationContext,Showhistory::class.java)
                startActivity(intent)

//                auth.signOut()
//                Firebase.auth.signOut()
//                startActivity(Intent(this,login::class.java))
//                finish()

            }

        }
        return true
    }
}