package com.yhe64.game

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.view.View
import androidx.core.view.isInvisible
import com.yhe64.game.GameModel
import com.yhe64.game.Card
import com.yhe64.game.Ace

class MainActivity : AppCompatActivity() {

    private lateinit var leftBackImageButton : ImageButton
    private lateinit var leftFaceImageButton: ImageButton
    private lateinit var middleBackImageButton : ImageButton
    private lateinit var middleFaceImageButton: ImageButton
    private lateinit var rightBackImageButton : ImageButton
    private lateinit var rightFaceImageButton: ImageButton
    private lateinit var playButton: Button
    private lateinit var resetButton: Button

    private val model = GameModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        leftBackImageButton = findViewById(R.id.card_left_back)
        leftFaceImageButton = findViewById(R.id.card_left_face)
        middleBackImageButton = findViewById(R.id.card_middle_back)
        middleFaceImageButton = findViewById(R.id.card_middle_face)
        rightBackImageButton = findViewById(R.id.card_right_back)
        rightFaceImageButton = findViewById(R.id.card_right_face)
        playButton = findViewById(R.id.play_button)
        resetButton = findViewById(R.id.reset_button)
        resetButton.isEnabled = false

    }

    fun onPlay(view: View){
        onPlayAnimate()
    }

    fun onReset(view: View){
        leftBackImageButton.visibility = View.VISIBLE
        leftFaceImageButton.visibility = View.INVISIBLE
        middleBackImageButton.visibility = View.VISIBLE
        middleFaceImageButton.visibility = View.INVISIBLE
        rightBackImageButton.visibility = View.VISIBLE
        rightFaceImageButton.visibility = View.INVISIBLE
        when(model.ace){
            Ace.LEFT->leftFaceImageButton.setImageResource(R.drawable.blank)
            Ace.MIDDLE->middleFaceImageButton.setImageResource(R.drawable.blank)
            Ace.RIGHT->rightFaceImageButton.setImageResource(R.drawable.blank)
        }
        onResetAnimate()
    }

    fun onPlayAnimate(){
        playButton.isEnabled = false
        resetButton.isEnabled = true

    }

    fun onResetAnimate(){
        resetButton.isEnabled = false
        playButton.isEnabled = true

    }
}