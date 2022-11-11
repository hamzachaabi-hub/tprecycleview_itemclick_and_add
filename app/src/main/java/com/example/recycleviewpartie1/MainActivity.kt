package com.example.recycleviewpartie1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(),myAdapter.OnItemClickListener {

    var values= arrayListOf<String>("item1", "item2" , "item3", "item4", "item5")
    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>
    lateinit var add: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        manager = LinearLayoutManager(this)
        myAdapter = myAdapter(values,this)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = manager
            adapter = myAdapter
        }
        add=findViewById(R.id.add)

        add.setOnClickListener {
            var n:Int = values.size + 1
            values.add("item$n") //Ajout dans la source de données
            myAdapter.notifyItemInserted(values.size)//Rafraichissement de l’adapter
        }

    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked",Toast.LENGTH_SHORT).show()
        values[position]="Clicked"
        myAdapter.notifyItemChanged(position)
    }
}