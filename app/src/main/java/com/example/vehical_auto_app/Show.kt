package com.example.vehical_auto_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class Show : AppCompatActivity() {

    var ref: DatabaseReference? = null
    var list: ArrayList<my>? = null
    private var listener: OurAdapter.RecyclerViewClickListener? = null

    var recyclerView: RecyclerView? = null

    var searchView: SearchView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        ref = FirebaseDatabase.getInstance().reference.child("service")
        recyclerView = findViewById(R.id.recyclerview)
        searchView = findViewById(R.id.searchview)

    }

    override fun onStart() {
        super.onStart()
        if (ref != null) {
            ref!!.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        list = ArrayList()
                        for (ds in snapshot.children) {
                            list!!.add(ds.getValue(my::class.java)!!)
                        }
                        setOnClickListner()


                        val adapter = OurAdapter(list, listener)
                        recyclerView!!.adapter = adapter
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(applicationContext, "error", Toast.LENGTH_SHORT).show()
                }
            })
        }


        if (searchView != null) {

            searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(s: String): Boolean {
                    return false
                }

                override fun onQueryTextChange(s: String): Boolean {
                    search(s)
                    return true
                }
            })
        }
    }

    private fun setOnClickListner() {


        listener =OurAdapter.RecyclerViewClickListener { v, position ->
            val intent = Intent(applicationContext, productdetails::class.java)
            intent.putExtra("gname", list!![position].garegename)
            intent.putExtra("address",list!![position].address)
            intent.putExtra("number",list!![position].number)
            intent.putExtra("imageurl",list!![position].imageurl)

            intent.putExtra("type",list!![position].type)
            intent.putExtra("service",list!![position].service)


            startActivity(intent)
        }

    }

    private fun search(s: String) {

        try{
            val mylist = ArrayList<my?>()
            for (`object` in list!!) {
                if (`object`!!.getAddress().toLowerCase().contains(s.toLowerCase())) {
                    mylist.add(`object`)
                }
            }
            val adapter = OurAdapter(mylist,listener)
            recyclerView!!.adapter = adapter
        }catch (e:Exception){
            e.printStackTrace()
        }

    }
}