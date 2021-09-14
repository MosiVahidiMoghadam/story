package com.example.story

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.story.dastanha.*
import kotlinx.android.synthetic.main.activity_my_note.*

class myNote : AppCompatActivity() {
    lateinit var setting: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_note)

    }

    override fun onResume() {
        setting = getSharedPreferences("set", Context.MODE_PRIVATE)
        button1.visibility = setting.getFloat("likeSeconed1", View.GONE.toFloat()).toInt()
        button2.visibility = setting.getFloat("likeSeconed2", View.GONE.toFloat()).toInt()
        button3.visibility = setting.getFloat("likeSeconed3", View.GONE.toFloat()).toInt()
        button4.visibility = setting.getFloat("likeSeconed4", View.GONE.toFloat()).toInt()
        button5.visibility = setting.getFloat("likeSeconed5", View.GONE.toFloat()).toInt()
        button6.visibility = setting.getFloat("likeSeconed6", View.GONE.toFloat()).toInt()
        button7.visibility = setting.getFloat("likeSeconed7", View.GONE.toFloat()).toInt()
        button8.visibility = setting.getFloat("likeSeconed8", View.GONE.toFloat()).toInt()
        button9.visibility = setting.getFloat("likeSeconed9", View.GONE.toFloat()).toInt()
        button10.visibility = setting.getFloat("likeSeconed10", View.GONE.toFloat()).toInt()
        setButton()
        noteActivity.setBackgroundColor(Color.parseColor(setting.getString("BackGround", "#FFFFFFFF")))
        super.onResume()
    }
    fun setButton() {
        button1.setOnClickListener {
            val intent = Intent(this, Story1::class.java)
            startActivity(intent)
            Toast.makeText(this, "داستان اول", Toast.LENGTH_SHORT).show()
        }
        button2.setOnClickListener {
            val intent = Intent(this, Story2::class.java)
            startActivity(intent)
            Toast.makeText(this, "داستان دوم", Toast.LENGTH_SHORT).show()

        }
        button3.setOnClickListener {
            val intent = Intent(this, Story3::class.java)
            startActivity(intent)
            Toast.makeText(this, "داستان سوم", Toast.LENGTH_SHORT).show()

        }
        button4.setOnClickListener {
            val intent = Intent(this, Story4::class.java)
            startActivity(intent)
            Toast.makeText(this, "داستان چهارم", Toast.LENGTH_SHORT).show()

        }
        button5.setOnClickListener {
            val intent = Intent(this, Story5::class.java)
            startActivity(intent)
            Toast.makeText(this, "داستان پنجم", Toast.LENGTH_SHORT).show()

        }
        button6.setOnClickListener {
            val intent = Intent(this, Story6::class.java)
            startActivity(intent)
            Toast.makeText(this, "داستان ششم", Toast.LENGTH_SHORT).show()

        }
        button7.setOnClickListener {
            val intent = Intent(this, Story7::class.java)
            startActivity(intent)
            Toast.makeText(this, "داستان هفتم", Toast.LENGTH_SHORT).show()

        }
        button8.setOnClickListener {
            val intent = Intent(this, Story8::class.java)
            startActivity(intent)
            Toast.makeText(this, "داستان هشتم", Toast.LENGTH_SHORT).show()

        }
        button9.setOnClickListener {
            val intent = Intent(this, Story9::class.java)
            startActivity(intent)
            Toast.makeText(this, "داستان نهم", Toast.LENGTH_SHORT).show()

        }
        button10.setOnClickListener {
            val intent = Intent(this, Story10::class.java)
            startActivity(intent)
            Toast.makeText(this, "داستان دهم", Toast.LENGTH_SHORT).show()

        }
    }


}