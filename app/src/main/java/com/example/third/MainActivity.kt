package com.example.third

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    lateinit var writeFragment: WriteFragment
    lateinit var readFragment: ReadFragment
    lateinit var database: PostDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        writeFragment = WriteFragment.newInstance()
        readFragment = ReadFragment.newInstance()
        database = Room.databaseBuilder(this, PostDatabase::class.java, "post")
            .build()
    }

    fun toView(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, readFragment)
            .commit()
    }

    fun toEdit(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, writeFragment)
            .commit()
    }

}