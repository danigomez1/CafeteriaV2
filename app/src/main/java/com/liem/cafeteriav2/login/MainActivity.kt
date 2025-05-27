package com.liem.cafeteriav2.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.liem.cafeteriav2.R
import com.liem.cafeteriav2.databinding.ActivityMainBinding
import com.liem.cafeteriav2.home.HomeActivity
import com.liem.cafeteriav2.register.RegisterActivity

class MainActivity : AppCompatActivity() {
    private val viewModel: LoginVM by viewModels();

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //SPLASH SCREEN
        Thread.sleep(1000)
        installSplashScreen()

        //DATA BINDING
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //LOGIN
        binding.btnLogin.setOnClickListener{
            if (viewModel.login(binding.etUsername.text.toString(), binding.etPassword.text.toString())) {
                Toast.makeText(this, "Correct user and password", Toast.LENGTH_LONG).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Incorrect user or password", Toast.LENGTH_LONG).show()
            }
        }

        //REGISTER
        binding.tvSignup.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}