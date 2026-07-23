package com.example.vehical_auto_app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.FirebaseDatabase

class UpdateProfile : AppCompatActivity() {
    var name: String? = null
    var number: String? = null
    var address: String? = null
    var type: String? = null
    var charges: String? = null
    var time: String? = null
    var docname: String? = null

    var username:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_update_profile)
        val prf = getSharedPreferences("Shop", MODE_PRIVATE)
        username = prf.getString("key", "")

        val eddname = findViewById<EditText>(R.id.eddname)
        val edhname = findViewById<EditText>(R.id.edhname)
        val edaddress = findViewById<EditText>(R.id.edhaddress)
        val eddesi = findViewById<EditText>(R.id.eddesi)
        val edcontact = findViewById<EditText>(R.id.edcontact)


        val btnupdate = findViewById<Button>(R.id.update)
        btnupdate.setOnClickListener {
            name = eddname.text.toString()
            number = edhname.text.toString()
            address = edaddress.text.toString()
            type = eddesi.text.toString()
            charges = edcontact.text.toString()


            val databaseReference =
                FirebaseDatabase.getInstance().getReference("service").child(username!!)
            databaseReference.child("garegename").setValue(name)
            databaseReference.child("number").setValue(number)
            databaseReference.child("type").setValue(address)
            databaseReference.child("service").setValue(type)
            databaseReference.child("address").setValue(charges)


            Toast.makeText(applicationContext, "Update", Toast.LENGTH_LONG).show()
        }


    }
}