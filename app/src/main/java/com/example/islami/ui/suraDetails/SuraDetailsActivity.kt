package com.example.islami.ui.suraDetails

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.Constants
import com.example.islami.R


class SuraDetailsActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: VersesAdapter
    lateinit var titleTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        titleTextView = findViewById(R.id.title_text_view)
        recyclerView = findViewById(R.id.recycler_View_sura_details)
        adapter = VersesAdapter()
        recyclerView.adapter = adapter

        val suraName: String = intent.getStringExtra(Constants.EXTRA_SURA_NAME) as String
        val suraPos = intent.getIntExtra(Constants.EXTRA_SURA_POS, -1)
        titleTextView.text = suraName
        readSuraFile("${suraPos + 1}.txt")

    }

    private fun readSuraFile(filaName: String) {
        val fileContent: String = assets.open(filaName).bufferedReader().use { it.readText() }
        val lines: List<String> = fileContent.split("\n")
        adapter.changeData(lines)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
