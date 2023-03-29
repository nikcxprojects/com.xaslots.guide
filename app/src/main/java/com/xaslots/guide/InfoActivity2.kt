package com.xaslots.guide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_info2.*

class InfoActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info2)

        val click_music = PreferenceManager.getDefaultSharedPreferences(this).getInt("click_music", 0)
        val text_index = intent.getIntExtra("text",0)
        val name = intent.getStringExtra("name")

        Handler(Looper.myLooper()!!).postDelayed(
            {
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putInt("onStops", 0).apply()
            }, 1000)

        textView4.text = name
        if(text_index == 1){
            textView5.setText(R.string.Randomness_in_slots)
        }else if(text_index == 2){
            textView5.setText(R.string.Progressive_jackpots)
        }else if(text_index == 3){
            textView5.setText(R.string.Reviewing_the_playtable)
        }else if(text_index == 4){
            textView5.setText(R.string.Playing_slowly)
        }else if(text_index == 5){
            textView5.setText(R.string.Studying_the_bonus_rounds)
        }else if(text_index == 6){
            textView5.setText(R.string.Make_sure_you_have_fun)
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