package com.xaslots.guide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val click_music = PreferenceManager.getDefaultSharedPreferences(this).getInt("click_music", 0)

        Handler(Looper.myLooper()!!).postDelayed(
            {
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putInt("onStops", 0).apply()
            }, 1000)

        button9.setOnClickListener {
            if(click_music != 0) {
                Music.mediaplayer_click!!.start()
            }
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 1).apply()
            val intent = Intent(this,InfoActivity2::class.java)
            intent.putExtra("text",1)
            intent.putExtra("name","Randomness in slots")
            startActivity(intent)
        }

        button6.setOnClickListener {
            if(click_music != 0) {
                Music.mediaplayer_click!!.start()
            }
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 1).apply()
            val intent = Intent(this,InfoActivity2::class.java)
            intent.putExtra("text",2)
            intent.putExtra("name","Progressive jackpots")
            startActivity(intent)
        }

        button7.setOnClickListener {
            if(click_music != 0) {
                Music.mediaplayer_click!!.start()
            }
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 1).apply()
            val intent = Intent(this,InfoActivity2::class.java)
            intent.putExtra("text",3)
            intent.putExtra("name","Reviewing the paytable")
            startActivity(intent)
        }

        button8.setOnClickListener {
            if(click_music != 0) {
                Music.mediaplayer_click!!.start()
            }
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 1).apply()
            val intent = Intent(this,InfoActivity2::class.java)
            intent.putExtra("text",4)
            intent.putExtra("name","Playing slowly")
            startActivity(intent)
        }

        button5.setOnClickListener {
            if(click_music != 0) {
                Music.mediaplayer_click!!.start()
            }
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 1).apply()
            val intent = Intent(this,InfoActivity2::class.java)
            intent.putExtra("text",5)
            intent.putExtra("name","Studying the bonus rounds")
            startActivity(intent)
        }

        button4.setOnClickListener {
            if(click_music != 0) {
                Music.mediaplayer_click!!.start()
            }
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 1).apply()
            val intent = Intent(this,InfoActivity2::class.java)
            intent.putExtra("text",6)
            intent.putExtra("name","Make sure you having fun")
            startActivity(intent)
        }

        button10.setOnClickListener {
            if(click_music != 0) {
                Music.mediaplayer_click!!.start()
            }
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 1).apply()
            onBackPressed()
        }
    }

    override fun onStop() {
        super.onStop()
        val onStops = PreferenceManager.getDefaultSharedPreferences(this).getInt("onStops", 0)
        if(onStops == 0){
            Music.mediaplayer_music!!.pause()
        }
    }
}