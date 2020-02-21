package com.example.stickyheaders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import eu.davidea.flexibleadapter.FlexibleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swipeLayout.isEnabled = false

        val headerOne = AdapterHeaderItem("HEADER #1")

        val sectionMinusOne = (-2..-1).map { AdapterSectionItem(null, "Sectionable #$it") }
        val sectionOne = (1..55).map { AdapterSectionItem(headerOne, "Sectionable #$it") }

        val adapter = FlexibleAdapter(sectionMinusOne + sectionOne)
            .setDisplayHeadersAtStartUp(true)
            .setStickyHeaders(true)

        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)

        recycler.addOnScrollListener(fab.createFabScrollListener())
    }
}
