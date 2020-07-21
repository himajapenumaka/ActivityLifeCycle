package com.ks.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity(){

    lateinit var etMob: EditText
    lateinit var etPw: EditText
    lateinit var btnLogin: Button
    lateinit var txtFp: TextView
    lateinit var txtRy: TextView
    lateinit var sharedPreferences: SharedPreferences
    val crctphnno="0123456789"
    val crctpw= arrayOf("tony","steve","thor","thanos")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("onCreate called")
        sharedPreferences=getSharedPreferences(getString(R.string.preferences_file_name),Context.MODE_PRIVATE)

        val isLoggedIn=sharedPreferences.getBoolean("isLoggedIn",false)

        setContentView(R.layout.activity_login)

        if(isLoggedIn){
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }

        title="Log In"

        etMob=findViewById(R.id.etMob)
        etPw=findViewById(R.id.etPw)
        btnLogin=findViewById(R.id.btnLogin)
        txtFp=findViewById(R.id.txtFp)
        txtRy=findViewById(R.id.txtRy)

        btnLogin.setOnClickListener {

            val phnno = etMob.text.toString()
            val pw = etPw.text.toString()
            var nameOfAvenger: String?
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)

            if (phnno == crctphnno) {
                if (pw == crctpw[0]) {
                    nameOfAvenger = "Iron Man"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                } else if (pw == crctpw[1]) {
                    nameOfAvenger = "Captain America"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                } else if (pw == crctpw[2]) {
                    nameOfAvenger = "Thor"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                } else if (pw == crctpw[3]) {
                    nameOfAvenger = "The Avengers"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                } else
                    Toast.makeText(this@LoginActivity, "Incorrect Credentials", Toast.LENGTH_SHORT)
                        .show()
            } else
                Toast.makeText(this@LoginActivity, "Incorrect Credentials", Toast.LENGTH_SHORT).show()
        }
        //Toast.makeText(this@LoginActivity,intent.getStringExtra("Logged out"),Toast.LENGTH_SHORT)
    }


    override fun onPause() {
        super.onPause()
        println("onPause called")
        finish()
    }

    fun savePreferences(title:String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }
}
