package com.example.vehical_auto_app

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class productdetails : AppCompatActivity() {

    var name:String?=null
    var address:String?=null
    var mobileno:String?=null
    var item1:String?=null
    var price1:String?=null
    var item2:String?=null
    var price2:String?=null
    var item3:String?=null
    var price3:String?=null
    var url:String?=null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productdetails)

        val txtname = findViewById<TextView>(R.id.txtname)
        val txtaddress = findViewById<TextView>(R.id.txtaddress)
        val txtmobile = findViewById<TextView>(R.id.txtmobile)
        val txtitem1 = findViewById<TextView>(R.id.txtitem1)
        val txtprice1 = findViewById<TextView>(R.id.txtprice1)


//        val btn = findViewById<Button>(R.id.btnsend)



        val image = findViewById<ImageView>(R.id.image1)
        val bundle = intent.extras



        name = bundle!!.getString("gname")
        address = bundle.getString("address")
        mobileno = bundle.getString("number")
        item1=bundle.getString("type")
        price1 = bundle.getString("service")
        item2=bundle.getString("rec3")

//        item3 = bundle.getString("place4")
//        price3 = bundle.getString("des4")

        url = bundle.getString("imageurl")

        Glide.with(applicationContext).load(url).into(image)

        txtname.setText("Garage Name: "+name)
        txtaddress.setText("Address: " +address)
        txtmobile.setText("Number: "+mobileno)
        txtitem1.setText("Type: " + item1)
        txtprice1.setText("Service: "+price1)


//        txtitem3.setText("Place4: "+item3)
//        txtprice3.setText("Description: "+price3)

        val btn = findViewById<Button>(R.id.btnsend)

        btn.setOnClickListener {

            val intent = Intent(applicationContext,userinfo::class.java)
            intent.putExtra("gname", name)
            intent.putExtra("address",address)
            intent.putExtra("number",mobileno)

            startActivity(intent)


        }

//        val btnpayment = findViewById<Button>(R.id.btnpayment)
//
//        btnpayment.setOnClickListener(){
//            val intent = Intent(applicationContext,Payment::class.java)
//            startActivity(intent)
//        }


        val btnfeedback = findViewById<Button>(R.id.btnfeedback)

        btnfeedback.setOnClickListener(){
            val intent = Intent(applicationContext,Addrating::class.java)
            intent.putExtra("gname", name)
            startActivity(intent)
        }



    }
}