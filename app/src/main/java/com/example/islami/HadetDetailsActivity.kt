package com.example.islami

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class HadetDetailsActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: VersesAdapter
    lateinit var titleTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_hadet_details)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        titleTextView = findViewById(R.id.title_text_view_hadeth)
        recyclerView = findViewById(R.id.recycler_View_hadeth_details)
        adapter = VersesAdapter()
        recyclerView.adapter = adapter

        val hadethNum: String = intent.getStringExtra(Constants.EXTRA_HADETH_NAME) as String
        val hadethPos = intent.getIntExtra(Constants.EXTRA_HADETH_POS, -1)
        titleTextView.text = hadethNum
        readHadethFile("${hadethPos + 115}.txt")

    }

    private fun readHadethFile(fileName: String) {
        val fileContent: String = assets.open(fileName).bufferedReader().use { it.readText() }
        val lines: List<String> = fileContent.split("\n")
        adapter.changeData(lines)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}

