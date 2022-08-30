package com.example.mediate_live_data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model=ViewModelProvider(this)[MainViewModel::class.java]//creating instance of view model
        model.firstPlayerScore.observe(this,Observer<Float>{score->previous_player_score_label.text=score.toString()

        })

        model.secondPlayerScore.observe(this,Observer<Float>{
           score->previous_player_score_label.text=score.toString()
        })


        submit_first_player_score.setOnClickListener { model.setFirstPlayerScore(
            first_player_score.text.toString().toFloat()
        ) }

        submit_second_player_score.setOnClickListener {
            model.setSecondPlayerScore(
                second_player_score.text.toString().toFloat()
            )
        }




    }
}