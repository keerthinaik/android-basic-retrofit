package com.example.btcareerdemo.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.btcareerdemo.R
import com.example.btcareerdemo.model.entities.User

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var users : List<User>? = null

    fun setUsers(users : List<User>?) {
        this.users = users
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users?.get(position)
        if (user != null) {
            holder.name.text = user.name
            holder.phone.text = user.phone
            holder.email.text = user.email
        }
    }

    override fun getItemCount(): Int {
        return this.users?.size ?: 0
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name:TextView = itemView.findViewById(R.id.tv_name)
        val phone:TextView = itemView.findViewById(R.id.tv_phone)
        val email:TextView = itemView.findViewById(R.id.tv_email)
    }
}