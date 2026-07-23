package com.example.vehical_auto_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class Showorder : AppCompatActivity() {

    private var database: FirebaseDatabase? = null
    private var ref: DatabaseReference? = null

    private var adapter:MyAdapter?=null
    private var list: ArrayList<User>? = null

    private  var mylist :ArrayList<String>?=null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showorder)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        list = ArrayList()


        val pref = getSharedPreferences("Shop", MODE_PRIVATE)
        val address = pref.getString("name", "default")
        Toast.makeText(applicationContext,address.toString(), Toast.LENGTH_LONG).show()
        database = FirebaseDatabase.getInstance()


        val mDatabaseRef = FirebaseDatabase.getInstance().getReference("order")

        val query: Query = mDatabaseRef.orderByChild("gname").equalTo(address)

        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                print(dataSnapshot)


                for (data in dataSnapshot.children) {
                    println(data)


                    val models: User? = data.getValue(User::class.java)
                    println(models)
                    if (models != null) {
                        list!!.add(models)
                    }







                }

                adapter = MyAdapter(list,applicationContext)
                recyclerView.adapter = adapter

            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })

    }


}