package com.example.vehical_auto_app

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class Shopprofile : AppCompatActivity() {

    private var database: FirebaseDatabase? = null
    private var mDatabase: DatabaseReference? = null
    var dname: String? = null
    var hname: String? = null
    var address: String? = null
    var desi: String? = null
    var service: String? = null
    var type: String? = null
    var uhname: String? = null
    var uhaddress: String? = null
    var udesi: String? = null
    var ucontact: String? = null
    var username: String? = null



    var sharedpreferences: SharedPreferences? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shopprofile)
        sharedpreferences = getSharedPreferences("Shop", MODE_PRIVATE)
        val name =  sharedpreferences!!.getString("name","")
        val key =  sharedpreferences!!.getString("key","")
        Toast.makeText(applicationContext,name.toString(), Toast.LENGTH_LONG).show()


        val btn = findViewById<Button>(R.id.btnupdate)

        btn.setOnClickListener {

            val intent = Intent(applicationContext, UpdateProfile::class.java)
            startActivity(intent)
        }

        database = FirebaseDatabase.getInstance()
        mDatabase = database!!.getReference("Doctor")
//        val update = findViewById<Button>(R.id.btnupdate)
        val txtdname = findViewById<TextView>(R.id.txtdname)
        val txthname = findViewById<TextView>(R.id.txthname)
        val txthaddress = findViewById<TextView>(R.id.txtadress)
        val txtage = findViewById<TextView>(R.id.txtage)
        val txt = findViewById<TextView>(R.id.txttype)

        val image1= findViewById<ImageView>(R.id.img1)



        val mDatabaseRef = FirebaseDatabase.getInstance().getReference("service")

        val query: Query = mDatabaseRef.orderByChild("garegename").equalTo(name)

        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (data in dataSnapshot.children) {
                    println(data)
                    val models: my? = data.getValue(my::class.java)

//                    val latitude: String = models!!.doctorname
//                    val longitude: String = models!!.Contactnumber
                    desi = models!!.garegename

                    hname = models!!.number
                    address = models!!.address
                    service = models!!.service
                    type = models!!.type


                    txtdname.setText("Name -"+desi)
                    txthname.setText("Mobile No -"+hname)
                    txthaddress.setText("Address -"+address)
                    txtage.setText("Services -"+service)
                    txt.setText("Type"+ type)

                    Glide.with(image1.getContext()).load(models.imageurl)
                        .into(image1)

                }

            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }
}