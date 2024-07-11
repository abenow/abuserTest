package com.tests.abusertest



import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity(), View.OnClickListener {
    private var buttonRemake: Button? = null
    private var buttonMainMenu: Button? = null

    private var telegramButton: ImageButton? = null
    private var vkontakteButton: ImageButton? = null
    private var twitterButton: ImageButton? = null


    private var result = ""
    private var r = 0
    private var shareText = ""

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        buttonRemake = findViewById(R.id.button_remake6b)
        buttonRemake!!.setOnClickListener(this)
        buttonMainMenu = findViewById(R.id.button_main_menu6b)
        buttonMainMenu!!.setOnClickListener(this)

        telegramButton = findViewById(R.id.telegramButton)
        telegramButton!!.setOnClickListener(this)
        vkontakteButton = findViewById(R.id.vkontakteButton)
        vkontakteButton!!.setOnClickListener(this)
        twitterButton = findViewById(R.id.twitterButton)
        twitterButton!!.setOnClickListener(this)

        r = intent.extras?.getInt("ageSendOne") ?: 0
        val imageView4: ImageView = findViewById(R.id.imageView6b)
        val textView: TextView = findViewById(R.id.textView30)

        if (r < 17) {
            imageView4.setImageResource(R.drawable.first_abuser_copy)
            textView.text = getString(R.string.less17)
            result = getString(R.string.less17)
        } else if (r <= 26) {
            imageView4.setImageResource(R.drawable.second_abuser)
            textView.text = getString(R.string.more16)
            result = getString(R.string.more16)
        } else {
            imageView4.setImageResource(R.drawable.third_abuser)
            textView.text = getString(R.string.more26)
            result = getString(R.string.more26)
        }




        shareText = "Привет, я прошёл(ла) тест на Абъюзера и вот мой резултат!$result"
    }

    @SuppressLint("QueryPermissionsNeeded")
    override fun onClick(v: View) {
        when (v.id) {
            R.id.telegramButton -> {
//                val telegramIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://telegram.me/share/url?text=$shareText"))
//                startActivity(telegramIntent)

                val telegramIntent = Intent(Intent.ACTION_SEND)
                telegramIntent.type = "text/plain"
                telegramIntent.putExtra(Intent.EXTRA_TEXT, shareText)
                if (telegramIntent.resolveActivity(packageManager) != null) {
                    startActivity(telegramIntent)
                }

            }

            R.id.vkontakteButton -> {
                val telegramIntent = Intent(Intent.ACTION_SEND)
                telegramIntent.type = "text/plain"
                telegramIntent.putExtra(Intent.EXTRA_TEXT, shareText)
                if (telegramIntent.resolveActivity(packageManager) != null) {
                    startActivity(telegramIntent)
                }
            }

            R.id.twitterButton -> {
                val telegramIntent = Intent(Intent.ACTION_SEND)
                telegramIntent.type = "text/plain"
                telegramIntent.putExtra(Intent.EXTRA_TEXT, shareText)
                if (telegramIntent.resolveActivity(packageManager) != null) {
                    startActivity(telegramIntent)
                }
            }

            R.id.button_remake6b -> {
                val intent1 = Intent(this, MainActivity::class.java)
                startActivity(intent1)
            }

            R.id.button_main_menu6b -> {
                val intent2 = Intent(this, MainActivity::class.java)
                startActivity(intent2)
            }
        }
    }
}

