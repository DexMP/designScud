package com.example.scud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Build



class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Полноэкранные режим
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }

        // Массивчик
        var ok: Array<String> = arrayOf("Отлично!", "Всё работает!", "Карта принята!", "Транзакция выполнена!")
        var no: Array<String> = arrayOf("Что-то пошло не так.", "Повторите попытку.", "Хмм что-то не так...", "Транзакция не прошла.")

        text.setOnClickListener{

            val index = (0..3).random()
            text.text = ok[index]

            Handler().postDelayed({
                text.text = "Приложите карту!"
            }, 2000)

            topPanel.setImageResource(R.drawable.top_green)
            bottomPanel.setImageResource(R.drawable.bot_green)
            leftPanel.setImageResource(R.drawable.left_green)
            rightPanel.setImageResource(R.drawable.right_green)

            topPanel.visibility = View.VISIBLE
            bottomPanel.visibility = View.VISIBLE
            leftPanel.visibility = View.VISIBLE
            rightPanel.visibility = View.VISIBLE

            Handler().postDelayed({
                topPanel.visibility = View.INVISIBLE
                bottomPanel.visibility = View.INVISIBLE
                leftPanel.visibility = View.INVISIBLE
                rightPanel.visibility = View.INVISIBLE
            }, 2000)
        }

        logo.setOnClickListener{

            val index = (0..3).random()
            text.text = no[index]

            Handler().postDelayed({
                text.text = "Приложите карту!"
            }, 2000)

            topPanel.setImageResource(R.drawable.top_red)
            bottomPanel.setImageResource(R.drawable.bot_red)
            leftPanel.setImageResource(R.drawable.left_red)
            rightPanel.setImageResource(R.drawable.right_red)

            topPanel.visibility = View.VISIBLE
            bottomPanel.visibility = View.VISIBLE
            leftPanel.visibility = View.VISIBLE
            rightPanel.visibility = View.VISIBLE

            Handler().postDelayed({
                topPanel.visibility = View.INVISIBLE
                bottomPanel.visibility = View.INVISIBLE
                leftPanel.visibility = View.INVISIBLE
                rightPanel.visibility = View.INVISIBLE
            }, 2000)
        }
    }
}