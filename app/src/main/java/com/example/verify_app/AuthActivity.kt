package com.example.verify_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val userlogin: EditText = findViewById(R.id.user_login_auth)
        val userpass: EditText = findViewById(R.id.user_pass_auth)
        val button = findViewById<Button>(R.id.button_auth)
        val LinkTOReg = findViewById<TextView>(R.id.TextView_go_auth)

        LinkTOReg.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener{
            val login = userlogin.text.toString().trim()
            val pass = userpass.text.toString().trim()

            if(login=="" || pass == ""){
                Toast.makeText(this, "Please chek all fields.", Toast.LENGTH_SHORT).show()
            }else{
                authorization(login,pass)
                if(DBHelper(this,null).getUser(login,pass)){
                    userlogin.text.clear()
                    userpass.text.clear()

                val intent = Intent(this,ItemsActivity::class.java)
                startActivity(intent)}
            }
        }
    }

    private fun authorization(login: String, pass: String) {
        val db = DBHelper(this,null)
        val isAuth = db.getUser(login,pass)

        if(isAuth) {
            Toast.makeText(this, "User $login auth", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "User $login not auth", Toast.LENGTH_SHORT).show()
        }
    }
}