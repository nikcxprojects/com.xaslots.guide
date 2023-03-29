package com.xaslots.guide

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import com.xaslots.guide.Music.mediaplayer_click
import com.xaslots.guide.Music.mediaplayer_music
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val click_music = PreferenceManager.getDefaultSharedPreferences(this).getInt("click_music", 0)

        mediaplayer_music = MediaPlayer.create(this,R.raw.music)
        mediaplayer_click = MediaPlayer.create(this,R.raw.click)

        mediaplayer_music!!.start()
        textView2.setOnClickListener {
            if(click_music != 0) {
                mediaplayer_click!!.start()
            }
            startActivity(Intent(this,WebActivity::class.java))
        }

        PreferenceManager.getDefaultSharedPreferences(this).edit()
            .putInt("onStops", 0).apply()

        button.setOnClickListener {
            if(click_music != 0) {
                mediaplayer_click!!.start()
            }
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 1).apply()
            startActivity(Intent(this,MainActivity2::class.java))
            finish()
        }

        button2.setOnClickListener {
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 0).apply()
            val a = Intent(Intent.ACTION_MAIN)
            a.addCategory(Intent.CATEGORY_HOME)
            a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(a)
        }

    }

    override fun onStop() {
        super.onStop()
        val onStops = PreferenceManager.getDefaultSharedPreferences(this).getInt("onStops", 0)
        if(onStops == 0){
            mediaplayer_music!!.pause()
        }
    }
}