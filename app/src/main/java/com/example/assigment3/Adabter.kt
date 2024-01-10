package com.example.assigment3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assigment3.databinding.ActivityContactMainBinding
import com.example.assigment3.databinding.ContactBinding

class Adabter (val items :List<Contact>): RecyclerView.Adapter<Adabter.ViewHOlder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHOlder {

       val view=LayoutInflater.from(parent.context).inflate(R.layout.contact,parent,false)
        return ViewHOlder(view)
    }

    override fun getItemCount(): Int =items?.size?:0

    override fun onBindViewHolder(holder: ViewHOlder, position:Int) {
        val contact =items?.get(position)
        holder.name.setText(contact?.name)
        holder.phoneNumber.setText(contact?.phoneNumber)
        holder.image.setImageResource(contact?.image!!)

        holder.name.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                onClickListner.onItemClick(position, contact)
            }
        })
        holder.phoneNumber.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                onClickListner.onItemClick(position,contact)
            }
        })
        holder.image.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                onClickListner.onItemClick(position,contact)
            }
        })
    }
    class ViewHOlder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var image: ImageView =itemView.findViewById(R.id.image_user)
        var name:TextView=itemView.findViewById(R.id.name)
        var phoneNumber:TextView=itemView.findViewById(R.id.phone_number)
    }
   lateinit var onClickListner :OnItemClick

    fun onClickListner(onImageClick: OnItemClick)
    {
        onClickListner=onImageClick
    }

    interface OnItemClick {
        fun onItemClick(position: Int,contact: Contact)
    }
}