package com.example.myrecipes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.myrecipes.R
import kotlinx.android.synthetic.main.activity_details.*

class UploadedDetailsActivity : AppCompatActivity() {

    lateinit var name: TextView
    lateinit var description: TextView
    lateinit var ingredients: TextView
    lateinit var instructions: TextView
    lateinit var category: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uploaded_details)

        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white))
        toolbar.title = "My Recipe Details"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        init()

        getAndSetIntents()


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun init() {

        name = findViewById<TextView>(R.id.name_txtView)
        description = findViewById<TextView>(R.id.description_txtView)
        ingredients = findViewById<TextView>(R.id.ingedients_txtView)
        instructions = findViewById<TextView>(R.id.instructions_txtView)
        category = findViewById<TextView>(R.id.category_txtView)
//        val name = findViewById<TextView>(R.id.name_txtView)
    }

    private fun getAndSetIntents() {

        var nameIntent: String? = intent.getStringExtra("name")
        var descriptionIntent: String? = intent.getStringExtra("description")
        var ingredientsIntent: String? = intent.getStringExtra("ingredients")
        var instructionsIntent: String? = intent.getStringExtra("instructions")
        var categoryIntent: String? = intent.getStringExtra("category")

        name.setText(nameIntent)
        description.setText(descriptionIntent)
        ingredients.setText(ingredientsIntent)
        instructions.setText(instructionsIntent)
        category.setText(categoryIntent)
    }
}