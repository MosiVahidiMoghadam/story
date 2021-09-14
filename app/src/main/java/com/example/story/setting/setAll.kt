package com.example.story.setting


import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.story.R
import kotlinx.android.synthetic.main.activity_set_first.*


open class setAll : AppCompatActivity() {
    val si1 = 20f
    val si2 = 30f
    val si3 = 40f
    val si4 = 15f
    val si5 = 25f
    val si6 = 35f
    lateinit var setting: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_first)
        setting = getSharedPreferences("set", Context.MODE_PRIVATE)
        txtaz.textSize = setting.getFloat("sizeText", si1)
        txtMat.textSize = setting.getFloat("sizeTextSecond", si4)
        backSetAll.setBackgroundColor(
            Color.parseColor(
                setting.getString(
                    "BackGround",
                    "#FFFFFFFF"
                )
            )
        )
        chBack.isChecked = setting.getBoolean("click", false)
        set()
        set2()
        setColor()
        rasize.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rasm -> {
                    val edit = setting.edit()
                    txtaz.setTextSize(si1)
                    edit.putFloat("sizeText", si1)
                    txtMat.setTextSize(si4)
                    edit.putFloat("sizeTextSecond", si4)
                    edit.commit()
                    set()
                }
                R.id.rano -> {
                    val edit = setting.edit()
                    txtaz.setTextSize(si2)
                    edit.putFloat("sizeText", si2)
                    txtMat.setTextSize(si5)
                    edit.putFloat("sizeTextSecond", si5)
                    edit.commit()
                    set()
                }
                R.id.rabi -> {
                    val edit = setting.edit()
                    txtaz.setTextSize(si3)
                    edit.putFloat("sizeText", si3)
                    txtMat.setTextSize(si6)
                    edit.putFloat("sizeTextSecond", si6)
                    edit.commit()
                    set()
                }
            }
        }
        racolor.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rabla -> {
                    val mm = setting.edit()
                    mm.putString("color", "#000000")
                    mm.putString("colorSecond", "#DF00332E")
                    mm.commit()
                    setColor()
                }
                R.id.rabro -> {
                    val mm = setting.edit()
                    mm.putString("color", "#807429")
                    mm.putString("colorSecond", "#B5807429")
                    mm.commit()
                    setColor()
                }
                R.id.ragra -> {
                    val mm = setting.edit()
                    mm.putString("color", "#FFC1C1C1")
                    mm.putString("colorSecond", "#9EDCDCDC")
                    mm.commit()
                    setColor()
                }
            }
        }
        chBack.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                val edit = setting.edit()
                edit.putString("BackGround", "#FF4C4C4C")
                backSetAll.setBackgroundColor(Color.parseColor("#FF4C4C4C"))
                chBack.isChecked = true
                edit.putBoolean("click", true)
                edit.commit()
            } else {
                val edit = setting.edit()
                edit.putString("BackGround", "#FFFFFFFF")
                backSetAll.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
                chBack.isChecked = false
                edit.putBoolean("click", false)
                edit.commit()
            }
        }
    }

    fun set() {
        when (setting.getFloat("sizeText", si1)) {
            si1 -> {
                rasize.check(R.id.rasm)
            }
            si2 -> {
                rasize.check(R.id.rano)
            }
            si3 -> {
                rasize.check(R.id.rabi)
            }
        }
    }

    fun set2() {
        when (setting.getFloat("sizeText", si1)) {
            si1 -> {
                rasm.isChecked = true
                rano.isChecked = false
                rabi.isChecked = false
            }
            si2 -> {
                rasm.isChecked = false
                rano.isChecked = true
                rabi.isChecked = false
            }
            si3 -> {
                rasm.isChecked = false
                rano.isChecked = false
                rabi.isChecked = true
            }
        }
    }

    fun setColor() {
        if (setting.getString("color", "#000000") != "") {
            txtaz.setTextColor(Color.parseColor(setting.getString("color", "#000000")))
            when (setting.getString("color", "#000000")) {
                "#000000" -> {
                    ragra.isChecked = false
                    rabro.isChecked = false
                    rabla.isChecked = true
                }
                "#807429" -> {
                    ragra.isChecked = false
                    rabro.isChecked = true
                    rabla.isChecked = false
                }
                "#FFC1C1C1" -> {
                    ragra.isChecked = true
                    rabro.isChecked = false
                    rabla.isChecked = false
                }
            }
            if (setting.getString("colorSecond", "C900332E") != "") {
                txtMat.setTextColor(Color.parseColor(setting.getString("colorSecond", "#DF00332E")))
            }
        }
    }
}