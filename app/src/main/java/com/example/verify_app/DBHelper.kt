package com.example.verify_app

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(val contex: Context, val factory: SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(contex,"app",factory,1){
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE users (id INT PRIMARY Key, login TEXT, email TEXT, pass TEXT)"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun addUSer(user: User){
        val values = ContentValues()
        values.put("login", user.Login)
        values.put("pass", user.pass)
        values.put("email", user.email)

        val db = this.writableDatabase
        db.insert("users",null,values)

        db.close()
    }

}