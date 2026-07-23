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

class Update : AppCompatActivity() {
    var name: String? = null
    var number: String? = null
    var address: String? = null
    var carno: String? = null
    var charges: String? = null
    var time: String? = null
    var docname: String? = null

    var username:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_update)
        val prf = getSharedPreferences("pdfdata", MODE_PRIVATE)
        username = prf.getString("key", "")

        val eddname = findViewById<EditText>(R.id.eddname)
        val edhname = findViewById<EditText>(R.id.edhname)
        val edaddress = findViewById<EditText>(R.id.edhaddress)
        val eddesi = findViewById<EditText>(R.id.eddesi)

        val btnupdate = findViewById<Button>(R.id.update)
        btnupdate.setOnClickListener {
            name = eddname.text.toString()
            number = edhname.text.toString()
            address = edaddress.text.toString()
            carno= eddesi.text.toString()

            val databaseReference =
                FirebaseDatabase.getInstance().getReference("Profile").child(username!!)
            databaseReference.child("name").setValue(name)
            databaseReference.child("number").setValue(number)
            databaseReference.child("address").setValue(address)
            databaseReference.child("Carno").setValue(carno)



            Toast.makeText(applicationContext, "Update", Toast.LENGTH_LONG).show()
        }


    }
}