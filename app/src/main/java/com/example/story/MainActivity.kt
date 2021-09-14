package com.example.story

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.story.dastanha.*
import com.example.story.setting.setAll
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var setting: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            val intent = Intent(this, Story1::class.java)
            startActivity(intent)
            Toast.makeText(this, "داستان اول", Toast.LENGTH_SHORT).show()
        }
        btn2.setOnClickListener {
            val intent = Intent(this, Story2::class.java)
            startActivity(intent)
            Toast.makeText(this, "داستان دوم", Toast.LENGTH_SHORT).show()
        }
        btn3.setOnClickListener {
            val intent = Intent(this, Story3::class.java)
            startActivity(intent)
            Toast.makeText(this, "داستان سوم", Toast.LENGTH_SHORT).show()
        }
        btn4.setOnClickListener {
            val intent = Intent(this, Story4::class.java)
            startActivity(intent)
            Toast.makeText(this, "داستان چهارم", Toast.LENGTH_SHORT).show()
        }
        btn5.setOnClickListener {
            val intent = Intent(this, Story5::class.java)
            startActivity(intent)
            Toast.makeText(this, "داستان پنجم", Toast.LENGTH_SHORT).show()
        }
        btn6.setOnClickListener {
            val intent = Intent(this, Story6::class.java)
            startActivity(intent)
            Toast.makeText(this, "داستان ششم", Toast.LENGTH_SHORT).show()
        }
        btn7.setOnClickListener {
            val intent = Intent(this, Story7::class.java)
            startActivity(intent)
            Toast.makeText(this, "داستان هفتم", Toast.LENGTH_SHORT).show()
        }
        btn9.setOnClickListener {
            val intent = Intent(this, Story8::class.java)
            startActivity(intent)
            Toast.makeText(this, "داستان نهم", Toast.LENGTH_SHORT).show()
        }
        btn10.setOnClickListener {
            val intent = Intent(this, Story9::class.java)
            startActivity(intent)
            Toast.makeText(this, "داستان دهم", Toast.LENGTH_SHORT).show()
        }
        btn8.setOnClickListener {
            val intent = Intent(this, Story10::class.java)
            startActivity(intent)
            Toast.makeText(this, "داستان هشتم", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.setting1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item != null)
            when (item.itemId) {
                R.id.setAval -> {
                    val intent = Intent(this, setAll::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "تنظیمات", Toast.LENGTH_SHORT).show()
                }
                R.id.likes -> {
                    val intent = Intent(this, myNote::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "علاقه مندی ها", Toast.LENGTH_SHORT).show()
                }
            }
        return true
    }

    override fun onResume() {
        setting = getSharedPreferences("set", Context.MODE_PRIVATE)
        firstActivity.setBackgroundColor(
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