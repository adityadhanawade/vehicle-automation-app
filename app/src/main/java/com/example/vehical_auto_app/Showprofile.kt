package com.example.vehical_auto_app

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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

class Showprofile : AppCompatActivity() {

    private var database: FirebaseDatabase? = null
    private var mDatabase: DatabaseReference? = null
    var dname: String? = null
    var hname: String? = null
    var address: String? = null
    var desi: String? = null
    var age: String? = null
    var udname: String? = null
    var uhname: String? = null
    var uhaddress: String? = null
    var udesi: String? = null
    var ucontact: String? = null
    var username: String? = null



    var sharedpreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_showprofile)
        sharedpreferences = getSharedPreferences("pdfdata", MODE_PRIVATE)
        val name =  sharedpreferences!!.getString("name","")
        val key =  sharedpreferences!!.getString("key","")
//        Toast.makeText(applicationContext,name.toString(), Toast.LENGTH_LONG).show()


        database = FirebaseDatabase.getInstance()
        mDatabase = database!!.getReference("Doctor")
//        val update = findViewById<Button>(R.id.btnupdate)
        val txtdname = findViewById<TextView>(R.id.txtdname)
        val txthname = findViewById<TextView>(R.id.txthname)
        val txthaddress = findViewById<TextView>(R.id.txtadress)
        val txtage = findViewById<TextView>(R.id.txtage)

        val image1= findViewById<ImageView>(R.id.img1)

        val btn = findViewById<Button>(R.id.btnupdate)

        btn.setOnClickListener {

            val intent = Intent(applicationContext, Update::class.java)

            startActivity(intent)
        }



        val mDatabaseRef = FirebaseDatabase.getInstance().getReference("Profile")

        val query: Query = mDatabaseRef.orderByChild("name").equalTo(name)

        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (data in dataSnapshot.children) {
                    println(data)
                    val models: Userprofile? = data.getValue(Userprofile::class.java)

//                    val latitude: String = models!!.doctorname
//                    val longitude: String = models!!.Contactnumber
                    desi = models!!.name

                    hname = models!!.number
                    address = models!!.address
                    age = models!!.carno

                    txtdname.setText("Name -"+desi)
                    txthname.setText("Mobile No -"+hname)
                    txthaddress.setText("Address -"+address)
                    txtage.setText("Car Number -"+age)

                    Glide.with(image1.getContext()).load(models.imageurl)
                        .into(image1)

                }

            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }
}