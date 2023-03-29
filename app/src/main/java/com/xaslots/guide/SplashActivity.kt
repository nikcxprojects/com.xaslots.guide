package com.xaslots.guide

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()
        Handler(Looper.myLooper()!!).postDelayed(
            {
                isOnline(this)
            }, 1000)
    }

    @SuppressLint("NewApi", "MissingPermission")
    fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    val uriUrl: Uri = Uri.parse("https://notezp.xyz/RgmtyfpM?id=com.xaslots.guide")
                    val launchBrowser = Intent(Intent.ACTION_VIEW, uriUrl)
                    startActivity(launchBrowser)
                    Log.d("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                }else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    val uriUrl: Uri = Uri.parse("https://notezp.xyz/RgmtyfpM?id=com.xaslots.guide")
                    val launchBrowser = Intent(Intent.ACTION_VIEW, uriUrl)
                    startActivity(launchBrowser)
                    Log.d("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                }else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    val uriUrl: Uri = Uri.parse("https://notezp.xyz/RgmtyfpM?id=com.xaslots.guide")
                    val launchBrowser = Intent(Intent.ACTION_VIEW, uriUrl)
                    startActivity(launchBrowser)
                    Log.d("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }else{
                    val uriUrl: Uri = Uri.parse("https://notezp.xyz/RgmtyfpM?id=com.xaslots.guide")
                    val launchBrowser = Intent(Intent.ACTION_VIEW, uriUrl)
                    startActivity(launchBrowser)
                    Log.d("Internet", "else Internet")
                }
            }else{
                val text = findViewById<TextView>(R.id.textView9)
                text.text = "No Connection"
                val progressBar = findViewById<ProgressBar>(R.id.progressBar)
                progressBar.visibility = View.GONE
                Log.d("Internet", "Error Internet")
            }
        }else{
            val text = findViewById<TextView>(R.id.textView9)
            text.text = "No Connection"
            val progressBar = findViewById<ProgressBar>(R.id.progressBar)
            progressBar.visibility = View.GONE
            Log.d("Internet", "Error Internet")
        }
        return false
    }
}