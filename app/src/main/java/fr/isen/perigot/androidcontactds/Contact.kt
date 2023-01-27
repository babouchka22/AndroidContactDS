package fr.isen.perigot.androidcontactds

import android.content.ClipData.Item

data class Contact (val nom: String, val adresse: String, val mail: String){

}

/*
import java.util.*

class Contact(val nom: String) {

    companion object {

        fun addContact(nom: String): ArrayList<Contact> {
            val contact = ArrayList<Contact>()
            for(value in nom){
                contact.add(Contact(value.toString()))
            }

            return contact
        }
    }
}*/