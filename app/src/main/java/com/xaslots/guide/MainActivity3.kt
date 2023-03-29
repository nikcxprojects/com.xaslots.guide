package com.xaslots.guide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

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
            val intent = Intent(this,InfoActivity1::class.java)
            intent.putExtra("text",1)
            intent.putExtra("name","Slot machines")
            startActivity(intent)
        }

        button6.setOnClickListener {
            if(click_music != 0) {
                Music.mediaplayer_click!!.start()
            }
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 1).apply()
            val intent = Intent(this,InfoActivity1::class.java)
            intent.putExtra("text",2)
            intent.putExtra("name","Roulette")
            startActivity(intent)
        }

        button7.setOnClickListener {
            if(click_music != 0) {
                Music.mediaplayer_click!!.start()
            }
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 1).apply()
            val intent = Intent(this,InfoActivity1::class.java)
            intent.putExtra("text",3)
            intent.putExtra("name","Poker")
            startActivity(intent)
        }

        button8.setOnClickListener {
            if(click_music != 0) {
                Music.mediaplayer_click!!.start()
            }
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 1).apply()
            val intent = Intent(this,InfoActivity1::class.java)
            intent.putExtra("text",4)
            intent.putExtra("name","BlackJack")
            startActivity(intent)
        }

        button5.setOnClickListener {
            if(click_music != 0) {
                Music.mediaplayer_click!!.start()
            }
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 1).apply()
            val intent = Intent(this,InfoActivity1::class.java)
            intent.putExtra("text",5)
            intent.putExtra("name","Baccarat")
            startActivity(intent)
        }

        button4.setOnClickListener {
            if(click_music != 0) {
                Music.mediaplayer_click!!.start()
            }
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 1).apply()
            val intent = Intent(this,InfoActivity1::class.java)
            intent.putExtra("text",6)
            intent.putExtra("name","Lotteries")
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