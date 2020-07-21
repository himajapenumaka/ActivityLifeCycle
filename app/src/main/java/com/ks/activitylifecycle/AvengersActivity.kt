package com.ks.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AvengersActivity : AppCompatActivity() {
    lateinit var etSomething:EditText
    lateinit var btnSend: Button
    lateinit var btnLogout: Button
    var titlename:String?="Avengers"
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.preferences_file_name), Context.MODE_PRIVATE)
        setContentView(R.layout.activity_avengers)
       titlename=sharedPreferences.getString("Title","The Avengers")
        title=titlename
        etSomething=findViewById(R.id.etSomething)
        btnSend=findViewById(R.id.btnSend)
        btnLogout=findViewById(R.id.btnLogout)
        btnSend.setOnClickListener(){
            val intent= Intent(this@AvengersActivity,MessageActivity::class.java)
            intent.putExtra("entered text",etSomething.text.toString())
            startActivity(intent)
        }
        btnLogout.setOnClickListener(){
            sharedPreferences.edit().clear().apply()

            val intent=Intent(this@AvengersActivity,LoginActivity::class.java)
            //intent.putExtra("Logged out","Logged out successfully")
            startActivity(intent)
            finish()
        }
    }

}
