package com.example.testhome

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter (private val context: Context) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    private var userList: ArrayList<UserResponse> = arrayListOf()

    fun setData(userList: ArrayList<UserResponse>) {
        this.userList = userList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        holder.bindData(user)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val username: TextView = itemView.findViewById(R.id.username)
        val job: TextView = itemView.findViewById(R.id.job)
        val company: TextView = itemView.findViewById(R.id.company)


        fun bindData(user: UserResponse) {
            username.text = user.name
            job.text = user.job_title
            company.text = user.workplace
        }
    }
}