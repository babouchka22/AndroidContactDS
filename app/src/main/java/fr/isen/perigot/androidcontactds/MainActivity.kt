package fr.isen.perigot.androidcontactds

import android.app.DownloadManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: AppCompatActivity
    private lateinit var contact : ArrayList<Contact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.Contact)
        val contactList = ArrayList<Contact>()

        recyclerView.adapter = ContactAdapter( contactList)
        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager = LinearLayoutManager(this)

        resources.getStringArray(fr.isen.perigot.androidcontactds.R.array.nom)
        resources.getStringArray(fr.isen.perigot.androidcontactds.R.array.adresse)
        resources.getStringArray(fr.isen.perigot.androidcontactds.R.array.mail)



    }


    private fun loadContactFromAPI() {
        //val queue = Volley.newRequestQueue(this)
        val url = "https://randomuser.me/api/?results=10&nat=fr"
        val jsonObject = JSONObject()
        //jsonObject.put("id_shop", "1")
        val jsonRequest = JsonObjectRequest(
            Request.Method.POST, url, jsonObject, {
                Log.w("MainActivity", "response : $it")
                //handleAPIData(it.toString())
            },
            {
                Log.e("MainActivity", "erreur : $it")
            })
        Volley.newRequestQueue(this).add(jsonRequest)
    }

/*
    private fun handleAPIData(data: String) {
        val gson = Gson()
        var ContactResult = gson.fromJson(data, DataResult::class.java)
        val contactCategory = ContactResult.data.firstOrNull { it.nameFr == category }

        val adapter = binding.categoryList.adapter as ContactAdapter
        adapter.refreshList(contactCategory?.items as ArrayList<String>)
    }
    companion object {
        fun fromJson(json: String): List<User> {
            val gson = Gson()
            val users = gson.fromJson(json, Array<User>::class.java)
            return users.toList()
        }
    }*/


/*
    fun displayList(contact : ArrayList<Contact>){

        // Create adapter passing in the sample user data
        val adapter = ContactAdapter(contact)
        val listeContact =findViewById<View>(R.id.Contact) as RecyclerView
        // Attach the adapter to the recyclerview to populate items
        listeContact.adapter = adapter
        // Set layout manager to position the items
        listeContact.layoutManager = LinearLayoutManager(this)
    }*/

}

