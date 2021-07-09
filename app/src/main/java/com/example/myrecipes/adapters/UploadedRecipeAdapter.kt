package com.example.myrecipes.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecipes.R
import com.example.myrecipes.models.UploadedRecipe
import com.example.myrecipes.ui.UploadedDetailsActivity


class UploadedRecipeAdapter(private val list: List<UploadedRecipe>) :
    RecyclerView.Adapter<UploadedRecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UploadedRecipeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return UploadedRecipeViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: UploadedRecipeViewHolder, position: Int) {
        val uploadedRecipe: UploadedRecipe = list[position]
        holder.bind(uploadedRecipe)
    }

    override fun getItemCount(): Int = list.size

}

class UploadedRecipeViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.upload_recipe_row_layout, parent, false)) {
    private var mNameView: TextView? = null
    private var mDesView: TextView? = null

    private var name = ""
    private var description = ""
    private var ingredients = ""
    private var instructions = ""
    private var category = ""
    private var image = ""



    init {
        mNameView = itemView.findViewById(R.id.uplodedName_txtView)
        mDesView = itemView.findViewById(R.id.uplodedDes_txtView)

        itemView.setOnClickListener { v ->
            val context: Context = v.context
            val intent = Intent(context, UploadedDetailsActivity::class.java)
            intent.putExtra("name",name)
            intent.putExtra("description",description)
            intent.putExtra("ingredients",ingredients)
            intent.putExtra("instructions",instructions)
            intent.putExtra("category",category)
            intent.putExtra("image",image)
            context.startActivity(intent)
        }


    }

    fun bind(uploadedRecipe: UploadedRecipe) {
        mNameView?.text = uploadedRecipe.name
        mDesView?.text = uploadedRecipe.description


        name = uploadedRecipe.name
        description = uploadedRecipe.description
        ingredients = uploadedRecipe.ingredients
        instructions = uploadedRecipe.instructions
        category = uploadedRecipe.category
        image = uploadedRecipe.image

    }

}