package fr.isen.perigot.androidcontactds

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ContactAdapter (val ContactAfficher : List<Contact>
                       )
    : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val contactIdentity: TextView = itemView.findViewById(R.id.contactIdentity)
        val contactAdresse: TextView = itemView.findViewById(R.id.contactAdresse)
        val contactMail: TextView = itemView.findViewById(R.id.contactMail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapter.ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ContactAdapter.ViewHolder, position: Int) {


            val contact = ContactAfficher[position]
            holder.contactIdentity.text = contact.nom
            holder.contactAdresse.text = contact.adresse
            holder.contactMail.text= contact.mail


    }


    override fun getItemCount(): Int {
        return ContactAfficher.size
    }





}