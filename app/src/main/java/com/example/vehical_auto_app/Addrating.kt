package com.example.vehical_auto_app

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.FirebaseDatabase

class Addrating : AppCompatActivity() {
    var edname: EditText?=null
    var edfeed: EditText?=null
    var edrating: EditText?=null
    var gname:String?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_addrating)
        edname = findViewById<EditText>(R.id.edname)
        edfeed = findViewById<EditText>(R.id.edfeedback)
        edrating = findViewById<EditText>(R.id.edrating)


        val bundle = intent.extras



        gname = bundle!!.getString("gname")
    }

    fun UploadData(view: View?) {
        val name = edname!!.text.toString()
        val feedback = edfeed!!.text.toString()
        val rating = edrating!!.text.toString()


        val data = FirebaseDatabase.getInstance().getReference().child("feedback")
        val service = Feedback(gname,name,feedback,rating)


        data.push().setValue(service)

        Toast.makeText(applicationContext,"Uploaded", Toast.LENGTH_LONG).show()



    }
}