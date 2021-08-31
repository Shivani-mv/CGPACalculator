package com.example.cgpacalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = Firebase.firestore

        buttonCalculate.setOnClickListener {
            if (EmailTextField.text.toString().isNullOrEmpty()){
                Toast.makeText(applicationContext, "Enter email to continue...", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this,CalculatorActivity::class.java)
                intent.putExtra("Email",EmailTextField.text.toString())
                startActivity(intent)
                val user= hashMapOf(
                    "Email" to EmailTextField.text.toString(),
                    "cgpa" to ""
                )
                db.collection("Users").document(EmailTextField.text.toString()).set(user)
                    .addOnSuccessListener {
                        documentReference ->
                    }
                    .addOnFailureListener{
                        e ->
                    }
            }

        }
        buttonCheckResults.setOnClickListener {
            if (EmailTextField.text.toString().isNullOrEmpty()){
                Toast.makeText(applicationContext, "Enter email to continue...", Toast.LENGTH_SHORT).show()
            }
            else
                {
                    val intent=Intent(this,PreviousAcitivity::class.java)
                    intent.putExtra("Email",EmailTextField.text.toString())
                    startActivity(intent)
                }
            }
        }
    }
