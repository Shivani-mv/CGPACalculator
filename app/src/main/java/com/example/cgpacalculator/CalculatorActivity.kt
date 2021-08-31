package com.example.cgpacalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_calculator.*
import java.math.RoundingMode

class CalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        val db=Firebase.firestore
        var cgpa=0.0
        //Toast.makeText(applicationContext, "Please enter 0 for Null values", Toast.LENGTH_LONG).show()

        var email=intent.getStringExtra("Email")
        var s1 = intent.getStringExtra("sem1")
        var s2 = intent.getStringExtra("sem2")
        var s3 = intent.getStringExtra("sem3")
        var s4 = intent.getStringExtra("sem4")
        var s5 = intent.getStringExtra("sem5")
        var s6 = intent.getStringExtra("sem6")
        var s7 = intent.getStringExtra("sem7")
        var s8 = intent.getStringExtra("sem8")
        semOne.setText(s1)
        semTwo.setText(s2)
        semThree.setText(s3)
        semFour.setText(s4)
        semFive.setText(s5)
        semSix.setText(s6)
        semSeven.setText(s7)
        semEight.setText(s8)

        buttonCalculateFinal.setOnClickListener {

            if (semOne.text.toString().isNullOrEmpty()||
                semTwo.text.toString().isNullOrEmpty()||
                semThree.text.toString().isNullOrEmpty()||
                semFour.text.toString().isNullOrEmpty()||
                semFive.text.toString().isNullOrEmpty()||
                semSix.text.toString().isNullOrEmpty()||
                semSeven.text.toString().isNullOrEmpty()||
                semEight.text.toString().isNullOrEmpty()
            ) {

                Toast.makeText(applicationContext, "Please enter 0 for unattempted semesters!", Toast.LENGTH_LONG).show()
            }


            else {
                var ss1 = 0.0
                var ss2 = 0.0
                var ss3 = 0.0
                var ss4 = 0.0
                var ss5 = 0.0
                var ss6 = 0.0
                var ss7 = 0.0
                var ss8 = 0.0


                 ss1 = semOne.text.toString().toDouble()
                 ss2 = semTwo.text.toString().toDouble()
                 ss3 = semThree.text.toString().toDouble()
                 ss4 = semFour.text.toString().toDouble()
                 ss5 = semFive.text.toString().toDouble()
                 ss6 = semSix.text.toString().toDouble()
                 ss7 = semSeven.text.toString().toDouble()
                 ss8 = semEight.text.toString().toDouble()

                if (ss8==0.0) {

                    cgpa =
                        ((24 * ss1) + (24 * ss2) + (27 * ss3) + (27 * ss4) + (24 * ss5) + (24 * ss6) + (24 * ss7) ) / 174
                }
                if (ss8==0.0 && ss7== 0.0) {

                    cgpa =
                        ((24 * ss1) + (24 * ss2) + (27 * ss3) + (27 * ss4) + (24 * ss5) + (24 * ss6) ) / 150
                }
                 if (ss8==0.0 &&  ss7==0.0 && ss6==0.0) {

                   cgpa =
                       ((24 * ss1) + (24 * ss2) + (27 * ss3) + (27 * ss4) + (24 * ss5) ) / 126
               }
                if (ss8 == 0.0 &&  ss7==0.0 &&  ss6==0.0 &&  ss5==0.0
               ) {

                   cgpa =
                       ((24 * ss1) + (24 * ss2) + (27 * ss3) + (27 * ss4)) / 102
               }
              if (ss8==0.0 && ss7==0.0 && ss6==0.0 && ss5==0.0 && ss4==0.0) {

                   cgpa =
                       ((24 * ss1) + (24 * ss2) + (27 * ss3)) / 75
               }
             if (ss8==0.0 && ss7==0.0 && ss6==0.0 && ss5==0.0 && ss4==0.0 && ss3==0.0) {

                   cgpa =
                       ((24 * ss1) + (24 * ss2)) / 48
               }
                if (ss8==0.0 && ss7==0.0 && ss6==0.0 && ss5==0.0 && ss4==0.0 && ss3==0.0 && ss2==0.0) {

                   cgpa =
                       ((24 * ss1) ) / 24
               }

                if (ss8==0.0 && ss7==0.0 && ss6==0.0 && ss5==0.0 && ss4==0.0 && ss3==0.0 && ss2==0.0 && ss1==0.0) {

                    Toast.makeText(applicationContext, "Complete at least one semester to calculate cgpa..... ", Toast.LENGTH_LONG).show()
                }
                if(ss8!=0.0 && ss7!=0.0 && ss6!=0.0 && ss5!=0.0 && ss4!=0.0 && ss3!=0.0 && ss2!=0.0 && ss1!=0.0) {

                    cgpa =
                        ((24 * ss1) + (24 * ss2) + (27 * ss3) + (27 * ss4) + (24 * ss5) + (24 * ss6) + (24 * ss7) + (26 * ss8)) / 200
                }

                var rcgpa = cgpa.toBigDecimal().setScale(2, RoundingMode.UP).toDouble()
                var scgpa = rcgpa.toString()
                val intent = Intent(this, FinalActivity::class.java)
                intent.putExtra("cgpa", scgpa)
                intent.putExtra("sem1", ss1.toString())
                intent.putExtra("sem2", ss2.toString())
                intent.putExtra("sem3", ss3.toString())
                intent.putExtra("sem4", ss4.toString())
                intent.putExtra("sem5", ss5.toString())
                intent.putExtra("sem6", ss6.toString())
                intent.putExtra("sem7", ss7.toString())
                intent.putExtra("sem8", ss8.toString())
                intent.putExtra("Email", email)
                startActivity(intent)

            }
        }

    }
}