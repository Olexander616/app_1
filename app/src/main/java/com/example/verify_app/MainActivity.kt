package com.example.verify_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val LinkTOAuth = findViewById<TextView>(R.id.TextView_go_reg)

        LinkTOAuth.setOnClickListener{
            val intent = Intent(this,AuthActivity::class.java)
            startActivity(intent)
        }

        val userlogin: EditText = findViewById(R.id.user_login)
        val userpass: EditText = findViewById(R.id.user_pass)
        val useremail: EditText = findViewById(R.id.user_email)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener{
            val login = userlogin.text.toString().trim()
            val pass = userpass.text.toString().trim()
            val email = useremail.text.toString().trim()

            if(login=="" || email=="" || pass == ""){
                Toast.makeText(this, "Please chek all fields.", Toast.LENGTH_SHORT).show()
            }else{
                registration(login,pass,email)
                userlogin.text.clear()
                useremail.text.clear()
                userpass.text.clear()
            }
        }


    }

    private fun registration(login:String, pass: String, email: String) {
        val user = User(login,pass,email)

        val db = DBHelper(this,null)
        db.addUSer(user)
        Toast.makeText(this,"User add",Toast.LENGTH_SHORT).show()
    }
}