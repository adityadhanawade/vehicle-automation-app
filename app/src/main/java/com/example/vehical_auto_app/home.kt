package com.example.vehical_auto_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView

class home : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val adddriver = findViewById<ImageView>(R.id.adddriver)

        adddriver.setOnClickListener {
            val intent = Intent(applicationContext, Addgarege::class.java)
            startActivity(intent)

        }

        val showcom = findViewById<ImageView>(R.id.showcom)

        showcom.setOnClickListener {
            val intent = Intent(applicationContext, Shopprofile::class.java)
            startActivity(intent)

        }

        val feedback = findViewById<ImageView>(R.id.feeback)

        feedback.setOnClickListener {
            val intent = Intent(applicationContext, Showfeedback::class.java)
            startActivity(intent)

        }

        val logout = findViewById<ImageView>(R.id.logout)

        logout.setOnClickListener {
            val intent = Intent(applicationContext, Showorder::class.java)
            startActivity(intent)

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
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)

//                auth.signOut()
//                Firebase.auth.signOut()
//                startActivity(Intent(this,login::class.java))
//                finish()

            }
            R.id.history -> {
                val intent = Intent(applicationContext, Showorder::class.java)
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