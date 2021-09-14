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
import kotlinx.android.synthetic.main.activity_story10.*

class Story10 : AppCompatActivity() {
    lateinit var setting: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story10)
        setting = getSharedPreferences("set", Context.MODE_PRIVATE)
        tV10.textSize = setting.getFloat("sizeText", 40f)
        tV101.textSize = setting.getFloat("sizeTextSecond", 35f)
        img_story10.visibility = setting.getFloat("like10", View.VISIBLE.toFloat()).toInt()
        img_story102.visibility = setting.getFloat("likeSeconed10", View.GONE.toFloat()).toInt()
        if (setting.getString("color", "#000000") != "") {
            tV10.setTextColor(Color.parseColor(setting.getString("color", "#000000")))
        }
        if (setting.getString("colorSecond", "C900332E") != "")
            tV101.setTextColor(Color.parseColor(setting.getString("color", "#000000")))


        img_story10.setOnClickListener {
            val edit = setting.edit()
            img_story10.visibility = View.GONE
            edit.putFloat("like10", View.GONE.toFloat())
            img_story102.visibility = View.VISIBLE
            edit.putFloat("likeSeconed10", View.VISIBLE.toFloat())
            edit.apply()
            Toast.makeText(this, "در علاقه مندی ها ذخیره شد", Toast.LENGTH_SHORT).show()
        }
        img_story102.setOnClickListener {
            val edit = setting.edit()
            img_story10.visibility = View.VISIBLE
            edit.putFloat("like10", View.VISIBLE.toFloat())
            img_story102.visibility = View.GONE
            edit.putFloat("likeSeconed10", View.GONE.toFloat())
            edit.apply()
            Toast.makeText(this, "از علاقه مندی ها برداشته شد", Toast.LENGTH_SHORT).show()
        }
    }

        override fun onResume() {
        setting = getSharedPreferences("set", Context.MODE_PRIVATE)
        storyDahom.setBackgroundColor(Color.parseColor(setting.getString("BackGround", "#FFFFFFFF")))
        super.onResume()
    }
}