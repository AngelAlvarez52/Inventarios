package com.angel520.inventarios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logo = findViewById<ImageView>(R.id.logo)

        logo.setOnClickListener {

            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}