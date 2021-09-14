package com.example.story.dastanha

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.story.R
import kotlinx.android.synthetic.main.activity_my_note.*
import kotlinx.android.synthetic.main.activity_story1.*
import kotlinx.android.synthetic.main.activity_story3.*

class Story3 : AppCompatActivity() {
    lateinit var setting: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story3)
        setting = getSharedPreferences("set", Context.MODE_PRIVATE)
        tV3.textSize = setting.getFloat("sizeText", 40f)
        tV31.textSize = setting.getFloat("sizeTextSecond", 35f)
        img_story3.visibility = setting.getFloat("like3", View.VISIBLE.toFloat()).toInt()
        img_story32.visibility = setting.getFloat("likeSeconed3", View.GONE.toFloat()).toInt()
        if (setting.getString("color", "#000000") != "") {
            tV3.setTextColor(Color.parseColor(setting.getString("color", "#000000")))
        }
        if (setting.getString("colorSecond", "C900332E") != "")
            tV31.setTextColor(Color.parseColor(setting.getString("color", "#000000")))

        img_story3.setOnClickListener {
            val edit = setting.edit()
            img_story3.visibility = View.GONE
            edit.putFloat("like3",View.GONE.toFloat())
//            imageView.visibility = View.GONE
//            edit.putFloat("imgLike",View.GONE.toFloat())
            img_story32.visibility = View.VISIBLE
            edit.putFloat("likeSeconed3",View.VISIBLE.toFloat())
            edit.apply()
            Toast.makeText(this,"در علاقه مندی ها ذخیره شد", Toast.LENGTH_SHORT).show()
        }
        img_story32.setOnClickListener {
            val edit = setting.edit()
            img_story3.visibility = View.VISIBLE
            edit.putFloat("like3",View.VISIBLE.toFloat())
            img_story32.visibility = View.GONE
            edit.putFloat("likeSeconed3",View.GONE.toFloat())
            edit.apply()
            Toast.makeText(this,"از علاقه مندی ها برداشته شد", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        setting = getSharedPreferences("set", Context.MODE_PRIVATE)
        storySevom.setBackgroundColor(Color.parseColor(setting.getString("BackGround", "#FFFFFFFF")))
        super.onResume()
    }
}