package com.example.xmlformat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private var student = ArrayList<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {


            var parser = MyXmlPullParser()
            val iStrem = assets.open("student_details.xml")
            student = parser.parse(iStrem)
            var adapter = RVAdapter(parser.parse(iStrem))
            rvMain.adapter = adapter
            rvMain.layoutManager = LinearLayoutManager(this)
            adapter.notifyDataSetChanged()

        }catch (e : IOException){
            print("Isuus $e")
        }


    }
}