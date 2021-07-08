package com.letscodee.retriverealtimedata

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MainActivity : AppCompatActivity() {
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var databaseReference: DatabaseReference
    lateinit var recyclerView: RecyclerView
    val adapter=RvAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Language");
        recyclerView=findViewById(R.id.rv)

        recyclerView.adapter=adapter
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager=layoutManager

        getData()

    }

    private fun getData() {
        val dataList= arrayListOf<String>()
        databaseReference.get().addOnSuccessListener {
            for(datas in it.children){
                val obj=datas.value
                dataList.add(obj.toString())
            }
            Log.d("Data",dataList.toString())
            adapter.submitList(dataList)
        }

    }
}