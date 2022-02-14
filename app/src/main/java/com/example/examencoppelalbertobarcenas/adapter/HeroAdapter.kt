package com.example.examencoppelalbertobarcenas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.examencoppelalbertobarcenas.R
import com.example.examencoppelalbertobarcenas.databinding.ItemHeroBinding
import com.example.examencoppelalbertobarcenas.model.response.HeroResponse
import com.squareup.picasso.Picasso
import kotlin.collections.ArrayList

class HeroAdapter (
    private val heros: ArrayList<HeroResponse>,
    val context: Context,
    val itemListener: (informationId: String) -> Unit,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ViewHolder(val binding: ItemHeroBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HeroResponse) {
            binding.apply {
                name = item.name
                Picasso.get().load(item.image.url).into(ivImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: ItemHeroBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_hero,
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int{
        return heros.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(heros.get(position))

        with(holder.binding) {
            ivImage.setOnClickListener {
                heros.get(position)?.id?.let { it1 -> itemListener(heros[position].id) }
            }

        }
    }
}