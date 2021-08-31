package com.example.cgpacalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_final.*
import kotlinx.android.synthetic.main.activity_previous_acitivity.*
import java.lang.StringBuilder


class PreviousAcitivity : AppCompatActivity() {
    val db= Firebase.firestore
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_previous_acitivity)
            val email=intent.getStringExtra("Email")
        val database = db.collection("Users").document(email.toString())
        database.addSnapshotListener { snapshot, e ->
            if (e != null) {

                return@addSnapshotListener
            }

            if (snapshot != null && snapshot.exists()) {
                var temp = StringBuilder("")
                temp.append(snapshot?.get("cgpa"))
                var cgpa = temp.toString()
                pcgpa.text=cgpa
            }
            else {

            }

        }
            back.setOnClickListener {
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }

    }

}