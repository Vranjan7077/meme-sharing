package com.example.memeshareapp


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.DoubleBounce
import com.github.ybq.android.spinkit.style.WanderingCubes


class SplashScreen : AppCompatActivity() {
    var splashProgress: ProgressBar? = null
    var SPLASH_TIME = 3000 //This is 3 seconds

    private var logo: ImageView? = null
    private var logo_text: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        logo = findViewById<View>(R.id.logo) as ImageView
        logo_text = findViewById<View>(R.id.logo_text) as TextView
        val animation1 = AnimationUtils.loadAnimation(applicationContext, R.anim.bounce)
        val animation2 = AnimationUtils.loadAnimation(applicationContext, R.anim.bottom)
        logo!!.startAnimation(animation1)
        logo_text!!.startAnimation(animation2)
        Handler().postDelayed({
            val intent = Intent(
                this@SplashScreen as Context?,
                MainActivity::class.java
            )
            //                intent.setFlags(67108864);
            this@SplashScreen.startActivity(intent)
            this@SplashScreen.finish()
        }, 3000)

        //This is additional feature, used to run a progress bar
        val progressBar = findViewById<View>(R.id.spin_kit) as ProgressBar
        val wanderingCubes: Sprite = WanderingCubes()
        progressBar.indeterminateDrawable = wanderingCubes
        Handler().postDelayed({
            val mySuperIntent = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(mySuperIntent)
            finish()
        }, SPLASH_TIME.toLong())
    }

}