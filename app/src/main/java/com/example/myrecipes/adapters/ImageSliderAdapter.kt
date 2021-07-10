//package com.example.myrecipes.adapters
//
//import android.R
//import android.content.Context
//import android.graphics.Color
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import android.widget.Toast
//import com.bumptech.glide.Glide
//import com.example.myrecipes.databinding.FavoriteRecipesRowLayoutBinding.inflate
//import com.example.myrecipes.models.SliderItem
//import com.smarteist.autoimageslider.SliderViewAdapter
//
//
//class ImageSliderAdapter
//internal class SliderAdapterExample(context: Context) :
//    SliderViewAdapter<SliderAdapterExample.SliderAdapterVH>() {
////    private val context: Context
//    private var mSliderItems: MutableList<SliderItem> = ArrayList()
//    fun renewItems(sliderItems: MutableList<SliderItem>) {
//        mSliderItems = sliderItems
//        notifyDataSetChanged()
//    }
//
//    fun deleteItem(position: Int) {
//        mSliderItems.removeAt(position)
//        notifyDataSetChanged()
//    }
//
//    fun addItem(sliderItem: SliderItem) {
//        mSliderItems.add(sliderItem)
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
//        val inflate: View =
//            LayoutInflater.inflate(R.layout., null)
//        return SliderAdapterVH(inflate)
//    }
//
//    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
//        val sliderItem: SliderItem = mSliderItems[position]
////        viewHolder.textViewDescription.setText(sliderItem.getDescription())
//        viewHolder.textViewDescription.textSize = 16f
//        viewHolder.textViewDescription.setTextColor(Color.WHITE)
//        Glide.with(viewHolder.itemView)
//            .load(sliderItem.imageUrl)
//            .fitCenter()
//            .into(viewHolder.imageViewBackground)
////        viewHolder.itemView.setOnClickListener(object : OnClickListener() {
////            fun onClick(v: View?) {
////                Toast.makeText(context, "This is item in position $position", Toast.LENGTH_SHORT)
////                    .show()
////            }
////        })
//    }
//
//    override fun getCount(): Int {
//        //slider view count could be dynamic size
//        return mSliderItems.size
//    }
//
//    internal inner class SliderAdapterVH(itemView: View) : ViewHolder(itemView) {
////         var itemView: View
//        var imageViewBackground: ImageView
//        var imageGifContainer: ImageView
//        var textViewDescription: TextView
//
//        init {
//            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider)
//            imageGifContainer = itemView.findViewById(R.id.iv_gif_container)
//            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider)
//            this.itemView = itemView
//        }
//    }
//
//    init {
////        this.context = context
//    }
//}