package com.ks.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MessageActivity : AppCompatActivity() {

    lateinit var txtMsg: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        var senttext:String?=""
        title="Sent Text"
        txtMsg=findViewById(R.id.txtMsg)
        if(intent!=null)
        senttext=intent.getStringExtra("entered text")
        txtMsg.setText(senttext)
    }
}
