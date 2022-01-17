package com.example.projectforexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.net.Uri


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

          infoShow()
          action()



    }

    fun infoShow(){
        val versionChecker = VersionChecker()
        val latestVersionT = versionChecker.execute().get()
        val currentVersionT = "6.2.4"



        val latestVersion =latestVersionT.split(".").toString()
        val currentVersion = currentVersionT.split(".").toString()


        if (latestVersion>currentVersion){
        val message:String = "new version: $latestVersion\' is available\'  current version is $currentVersion"
        tv_show.text = message}
        else  tv_show.text = "good"
    }

    fun action(){

        btn_check.setOnClickListener(){
            val url = "https://play.google.com/store/apps/details?id=net.giosis.shopping.sg&hl=en&gl=US"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

    }
}