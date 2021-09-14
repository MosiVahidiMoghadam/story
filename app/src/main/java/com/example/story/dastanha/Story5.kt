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
import kotlinx.android.synthetic.main.activity_story5.*

class Story5 : AppCompatActivity() {
    lateinit var setting: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story5)
        setting = getSharedPreferences("set", Context.MODE_PRIVATE)
        tV5.textSize = setting.getFloat("sizeText", 40f)
        tV51.textSize = setting.getFloat("sizeTextSecond", 35f)
        img_story5.visibility = setting.getFloat("like5", View.VISIBLE.toFloat()).toInt()
        img_story52.visibility = setting.getFloat("likeSeconed5", View.GONE.toFloat()).toInt()
        if (setting.getString("color", "#000000") != "") {
            tV5.setTextColor(Color.parseColor(setting.getString("color", "#000000")))
        }
        if (setting.getString("colorSecond", "C900332E") != "")
            tV51.setTextColor(Color.parseColor(setting.getString("color", "#000000")))

        img_story5.setOnClickListener {
            val edit = setting.edit()
            img_story5.visibility = View.GONE
            edit.putFloat("like5", View.GONE.toFloat())
            img_story52.visibility = View.VISIBLE
            edit.putFloat("likeSeconed5", View.VISIBLE.toFloat())
            edit.apply()
            Toast.makeText(this,"در علاقه مندی ها ذخیره شد", Toast.LENGTH_SHORT).show()
        }
        img_story52.setOnClickListener {
            val edit = setting.edit()
            img_story5.visibility = View.VISIBLE
            edit.putFloat("like5", View.VISIBLE.toFloat())
            img_story52.visibility = View.GONE
            edit.putFloat("likeSeconed5", View.GONE.toFloat())
            edit.apply()
            Toast.makeText(this,"از علاقه مندی ها برداشته شد", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        setting = getSharedPreferences("set", Context.MODE_PRIVATE)
        storyPanjom.setBackgroundColor(
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