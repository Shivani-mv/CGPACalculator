package com.example.cgpacalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_final.*
import java.lang.StringBuilder

class FinalActivity : AppCompatActivity() {
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
        var s1 = intent.getStringExtra("sem1")
        var s2 = intent.getStringExtra("sem2")
        var s3 = intent.getStringExtra("sem3")
        var s4 = intent.getStringExtra("sem4")
        var s5 = intent.getStringExtra("sem5")
        var s6 = intent.getStringExtra("sem6")
        var s7 = intent.getStringExtra("sem7")
        var s8 = intent.getStringExtra("sem8")
        var cgpa = intent.getStringExtra("cgpa")
        var email=intent.getStringExtra("Email")
        finalcgpa.text = "Calculated CGPA is : "+cgpa
        sem1.text="Semester 1 : "+s1
        sem2.text="Semester 2 : "+s2
        sem3.text="Semester 3 : "+s3
        sem4.text="Semester 4 : "+s4
        sem5.text="Semester 5 : "+s5
        sem6.text="Semester 6 : "+s6
        sem7.text="Semester 7 : "+s7
        sem8.text="Semester 8 : "+s8
        var NoOfResults=0
        val database = db.collection("Users").document(email.toString())
        database.addSnapshotListener { snapshot, e ->
            if (e != null) {

                return@addSnapshotListener
            }

            if (snapshot != null && snapshot.exists()) {

//
            }
            else {

            }
        }
        buttonEdit.setOnClickListener {
            val intent = Intent(this,CalculatorActivity::class.java)
            intent.putExtra("sem1",s1.toString())
            intent.putExtra("sem2",s2.toString())
            intent.putExtra("sem3",s3.toString())
            intent.putExtra("sem4",s4.toString())
            intent.putExtra("sem5",s5.toString())
            intent.putExtra("sem6",s6.toString())
            intent.putExtra("sem7",s7.toString())
            intent.putExtra("sem8",s8.toString())
            startActivity(intent)
        }
        save.setOnClickListener {
            database.update("cgpa",cgpa)
        }
    }
}