package com.example.story.dastanha

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.story.R
import kotlinx.android.synthetic.main.activity_story1.*
import kotlinx.android.synthetic.main.activity_story8.*

class Story8 : AppCompatActivity() {
    lateinit var setting: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story8)
        setting = getSharedPreferences("set", Context.MODE_PRIVATE)
        tV8.textSize = setting.getFloat("sizeText", 40f)
        tV81.textSize = setting.getFloat("sizeTextSecond", 35f)
        img_story8.visibility = setting.getFloat("like8", View.VISIBLE.toFloat()).toInt()
        img_story82.visibility = setting.getFloat("likeSeconed8", View.GONE.toFloat()).toInt()
        if (setting.getString("color", "#000000") != "") {
            tV8.setTextColor(Color.parseColor(setting.getString("color", "#000000")))
        }
        if (setting.getString("colorSecond", "C900332E") != "")
            tV81.setTextColor(Color.parseColor(setting.getString("color", "#000000")))


        img_story8.setOnClickListener {
            val edit = setting.edit()
            img_story8.visibility = View.GONE
            edit.putFloat("like8",View.GONE.toFloat())
            img_story82.visibility = View.VISIBLE
            edit.putFloat("likeSeconed8",View.VISIBLE.toFloat())
            edit.apply()
            Toast.makeText(this,"در علاقه مندی ها ذخیره شد",Toast.LENGTH_SHORT).show()
        }
        img_story82.setOnClickListener {
            val edit = setting.edit()
            img_story8.visibility = View.VISIBLE
            edit.putFloat("like8",View.VISIBLE.toFloat())
            img_story82.visibility = View.GONE
            edit.putFloat("likeSeconed8",View.GONE.toFloat())
            edit.apply()
            Toast.makeText(this,"از علاقه مندی ها برداشته شد",Toast.LENGTH_SHORT).show()
        }

    }

    override fun onResume() {
        setting = getSharedPreferences("set", Context.MODE_PRIVATE)
        storyHashtom.setBackgroundColor(
            Color.parseColor(
                setting.getString(
                    "BackGround",
                    "#FFFFFFFF"
                )
            )
        )
        super.onResume()
    }
}