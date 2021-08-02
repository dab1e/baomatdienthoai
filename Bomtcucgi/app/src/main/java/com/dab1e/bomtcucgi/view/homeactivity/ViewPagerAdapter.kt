package com.dab1e.bomtcucgi.view.homeactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.dab1e.bomtcucgi.R

class ViewPagerAdapter(list: ArrayList<String>,viewpager: ViewPager2) : RecyclerView.Adapter<ViewPagerAdapter.MyViewHolder>() {
    private val list  = list
    private val viewPager2 = viewpager

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.itemviewpager2,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Glide.with(holder.itemView.context).load(list[position]).into(holder.image)

        if (position == list.size-2){
            viewPager2.post(run)
        }
    }

    override fun getItemCount(): Int = list.size

    private val run =  Runnable{
        list.addAll(list)
        notifyDataSetChanged()
    }




    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image:ImageView = itemView.findViewById(R.id.img_viewpager)
    }
}
