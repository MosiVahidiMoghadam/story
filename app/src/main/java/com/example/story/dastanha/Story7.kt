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
import kotlinx.android.synthetic.main.activity_story7.*

class Story7 : AppCompatActivity() {
    lateinit var setting: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story7)
        setting = getSharedPreferences("set", Context.MODE_PRIVATE)
        tV7.textSize = setting.getFloat("sizeText", 40f)
        tV71.textSize = setting.getFloat("sizeTextSecond", 35f)
        img_story7.visibility = setting.getFloat("like7", View.VISIBLE.toFloat()).toInt()
        img_story72.visibility = setting.getFloat("likeSeconed7", View.GONE.toFloat()).toInt()
        if (setting.getString("color", "#000000") != "") {
            tV7.setTextColor(Color.parseColor(setting.getString("color", "#000000")))
        }
        if (setting.getString("colorSecond", "C900332E") != "")
            tV71.setTextColor(Color.parseColor(setting.getString("color", "#000000")))


        img_story7.setOnClickListener {
            val edit = setting.edit()
            img_story7.visibility = View.GONE
            edit.putFloat("like7",View.GONE.toFloat())
            img_story72.visibility = View.VISIBLE
            edit.putFloat("likeSeconed7",View.VISIBLE.toFloat())
            edit.apply()
            Toast.makeText(this,"در علاقه مندی ها ذخیره شد",Toast.LENGTH_SHORT).show()
        }
        img_story72.setOnClickListener {
            val edit = setting.edit()
            img_story7.visibility = View.VISIBLE
            edit.putFloat("like7",View.VISIBLE.toFloat())
            img_story72.visibility = View.GONE
            edit.putFloat("likeSeconed7",View.GONE.toFloat())
            edit.apply()
            Toast.makeText(this,"از علاقه مندی ها برداشته شد",Toast.LENGTH_SHORT).show()
        }

    }

    override fun onResume() {
        setting = getSharedPreferences("set", Context.MODE_PRIVATE)
        storyHaftom.setBackgroundColor(
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