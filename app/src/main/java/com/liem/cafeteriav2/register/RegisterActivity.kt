package com.liem.cafeteriav2.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.liem.cafeteriav2.R
import com.liem.cafeteriav2.databinding.ActivityMainBinding
import com.liem.cafeteriav2.databinding.ActivityRegisterBinding
import com.liem.cafeteriav2.login.LoginVM
import com.liem.cafeteriav2.login.MainActivity

class RegisterActivity : AppCompatActivity() {
    private val viewModel: RegisterVM by viewModels();

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //DATA BINDING
        val binding: ActivityRegisterBinding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        enableEdgeToEdge()
        //setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //REGISTER
        binding.btnRegister.setOnClickListener {
            if (binding.etUsername.text.toString().isEmpty() && binding.etPassword.text.toString().isEmpty()) {
                Toast.makeText(this, "Username and password cannot be empty!", Toast.LENGTH_LONG).show()
            }
            else if (binding.etUsername.text.toString().isEmpty()) {
                Toast.makeText(this, "Username cannot be empty!", Toast.LENGTH_LONG).show()
            }
            else if (binding.etPassword.text.toString().isEmpty()) {
                Toast.makeText(this, "Password cannot be empty!", Toast.LENGTH_LONG).show()
            }
            else {
                viewModel.createUser(binding.etUsername.text.toString(), binding.etPassword.text.toString())
                Toast.makeText(this, "User correctly created!", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        //LOGING
        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}