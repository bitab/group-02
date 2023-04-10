package com.example.quizapp

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var answer1 = false;
    var answer2 = false;
    var answer3 = false;
    var answer4 = true;
    var firstAnswer = false;

    val MY_TAG = "MyApp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.answer1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                answer1 = true;
                Toast.makeText(
                    applicationContext,
                    "You have chosen answer1",
                    Toast.LENGTH_LONG
                ).show()
            }else{
                answer1 = false;
            }
        };

        binding.answer2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                answer2 = true;
                Toast.makeText(
                    applicationContext,
                    "You have chosen answer2",
                    Toast.LENGTH_LONG
                ).show()
            }else{
                answer2 = true;
            }
        };

        binding.answer3.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                answer3 = true;
                Toast.makeText(
                    applicationContext,
                    "You have chosen answer3",
                    Toast.LENGTH_LONG
                ).show()
            }else{
                answer3 = false;
            }
        };

        binding.answer4.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                answer4 = false;
                Toast.makeText(
                    applicationContext,
                    "You have chosen answer4",
                    Toast.LENGTH_LONG
                ).show()
            }else{
                answer4 = true;
            }
        };

        binding.rg.setOnCheckedChangeListener { group, checkedId ->
            val clicked = group.findViewById(checkedId) as RadioButton
            val checked = clicked.isChecked
            firstAnswer = false;
            if (checked) {
                if(clicked.text.toString() == ".dex"){
                    firstAnswer = true;
                }
                Toast.makeText(
                    applicationContext,
                    clicked.text.toString() + " Selected",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun clickSubmit(view: View) {

        var secondAnswer = answer1 && answer2 && answer3 && answer4;
        Log.i(MY_TAG, "answer $answer1, $answer2, $answer3, $answer4 ")

        Toast.makeText(
            applicationContext,
            "answer $answer1, $answer2, $answer3, $answer4 ",
            Toast.LENGTH_LONG
        ).show()

        var totalScore = 0;
        if(secondAnswer){
            totalScore += 50;
        }
        if(firstAnswer){
            totalScore += 50;
        }

        Log.i(MY_TAG, "totalScore $totalScore")

        val builder = AlertDialog.Builder(this)

        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm")
        val current = formatter.format(time)

        Log.i(MY_TAG, "current $current")

        builder.setTitle("Alert Message")
        builder.setMessage("“Congratulations! You submitted on $current, Your achieved $totalScore%")
        builder.setIcon(R.drawable.alerticon)
        builder.setPositiveButton("Exit"){dialogInterface, which ->
            dialogInterface.dismiss()
            finish()
        }
        builder.setNegativeButton("Ok"){dialogInterface, which ->
            dialogInterface.dismiss()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()

    }

    fun clickReset(view: View) {
         answer1 = false;
         answer2 = false;
         answer3 = false;
         answer4 = true;
//         firstAnswer = false;
         Log.i(MY_TAG, "Resetting........")

        binding.answer1.setChecked(false);
        binding.answer2.setChecked(false);
        binding.answer3.setChecked(false);
        binding.answer4.setChecked(false);

        binding.rbkt.isChecked = false
        binding.rbdex.isChecked = false
        binding.rbclass.isChecked = false
        binding.jsclass.isChecked = false
    }

}