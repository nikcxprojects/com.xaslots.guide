package com.xaslots.guide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.preference.PreferenceManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        imageView6.setOnClickListener {
            imageView6.visibility = View.GONE
            imageView7.visibility = View.VISIBLE
            Music.mediaplayer_music!!.pause()
        }



        imageView5.setOnClickListener {
            imageView5.visibility = View.GONE
            imageView8.visibility = View.VISIBLE
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 1).apply()
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("click_music", 0).apply()
        }

        imageView7.setOnClickListener {
            imageView6.visibility = View.VISIBLE
            imageView7.visibility = View.GONE
            Music.mediaplayer_music!!.start()
        }

        imageView8.setOnClickListener {
            imageView5.visibility = View.VISIBLE
            imageView8.visibility = View.GONE
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 0).apply()
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("click_music", 1).apply()
        }

        button3.setOnClickListener {
            val click_music = PreferenceManager.getDefaultSharedPreferences(this).getInt("click_music", 0)
            if(click_music != 0) {
                Music.mediaplayer_click!!.start()
            }
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 1).apply()
            startActivity(Intent(this,MainActivity3::class.java))
        }

        button.setOnClickListener {
            val click_music = PreferenceManager.getDefaultSharedPreferences(this).getInt("click_music", 0)
            if(click_music != 0) {
                Music.mediaplayer_click!!.start()
            }
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 1).apply()
            startActivity(Intent(this,MainActivity4::class.java))
        }
        Handler(Looper.myLooper()!!).postDelayed(
            {
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putInt("onStops", 0).apply()
            }, 1000)

    }

    override fun onStop() {
        super.onStop()
        val onStops = PreferenceManager.getDefaultSharedPreferences(this).getInt("onStops", 0)
        if(onStops == 0){
            Music.mediaplayer_music!!.pause()
        }
    }
}