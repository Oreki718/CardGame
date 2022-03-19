package com.yhe64.game

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
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
        leftBackImageButton.isEnabled = false
        middleBackImageButton.isEnabled = false
        rightBackImageButton.isEnabled = false
    }

    fun onPlay(view: View){
        playButton.isEnabled = false
        showCard()
        leftBackImageButton.isEnabled = true
        middleBackImageButton.isEnabled = true
        rightBackImageButton.isEnabled = true
        model.playGame()
        initFace()
        resetButton.isEnabled = true
    }

    fun onReset(view: View){
        resetButton.isEnabled = false
        leftBackImageButton.isEnabled = false
        middleBackImageButton.isEnabled = false
        rightBackImageButton.isEnabled = false
        leftBackImageButton.visibility = View.VISIBLE
        leftFaceImageButton.visibility = View.INVISIBLE
        middleBackImageButton.visibility = View.VISIBLE
        middleFaceImageButton.visibility = View.INVISIBLE
        rightBackImageButton.visibility = View.VISIBLE
        rightFaceImageButton.visibility = View.INVISIBLE
        resetFace()
        onResetAnimate()
        playButton.isEnabled = true
    }

    private fun showCard(){
        val leftBackAnimator = ObjectAnimator.ofFloat(leftBackImageButton, "translationX", 0f, -600f)
        val leftFaceAnimator = ObjectAnimator.ofFloat(leftFaceImageButton, "translationX", 0f, -600f)
        val rightBackAnimator = ObjectAnimator.ofFloat(rightBackImageButton, "translationX", 0f, 600f)
        val rightFaceAnimator = ObjectAnimator.ofFloat(rightFaceImageButton, "translationX", 0f, 600f)
        val animatorSet = AnimatorSet()
        animatorSet.interpolator = AccelerateDecelerateInterpolator()
        animatorSet.play(leftBackAnimator)
        animatorSet.play(leftFaceAnimator)
        animatorSet.play(rightBackAnimator)
        animatorSet.play(rightFaceAnimator)
        animatorSet.duration = 1000
        animatorSet.start()

    }

    private fun onResetAnimate(){
        val leftBackAnimator = ObjectAnimator.ofFloat(leftBackImageButton, "translationX", -600f, 0f)
        val leftFaceAnimator = ObjectAnimator.ofFloat(leftFaceImageButton, "translationX", -600f, 0f)
        val rightBackAnimator = ObjectAnimator.ofFloat(rightBackImageButton, "translationX", 600f, 0f)
        val rightFaceAnimator = ObjectAnimator.ofFloat(rightFaceImageButton, "translationX", 600f, 0f)
        val animatorSet = AnimatorSet()
        animatorSet.play(leftBackAnimator)
        animatorSet.play(leftFaceAnimator)
        animatorSet.play(rightBackAnimator)
        animatorSet.play(rightFaceAnimator)
        animatorSet.duration = 1000
        animatorSet.start()
    }

    private fun resetFace(){
        leftFaceImageButton.setImageResource(R.drawable.blank)
        middleFaceImageButton.setImageResource(R.drawable.blank)
        rightFaceImageButton.setImageResource(R.drawable.blank)
    }

    private fun initFace(){
        resetFace()
        when(model.ace){
            Ace.LEFT -> leftFaceImageButton.setImageResource(R.drawable.ace)
            Ace.MIDDLE -> middleFaceImageButton.setImageResource(R.drawable.ace)
            Ace.RIGHT -> rightFaceImageButton.setImageResource(R.drawable.ace)
        }
    }

    fun onLeftClick(view: View){
        val leftRotateAnimator1 = ObjectAnimator.ofFloat(leftBackImageButton, "rotationY", 0f, 90f)
        val leftRotateAnimator2 = ObjectAnimator.ofFloat(leftFaceImageButton, "rotationY", -90f, 0f)
        val leftRotateAnimator3 = ObjectAnimator.ofFloat(leftBackImageButton,"rotationY", 90f,0f)
        leftRotateAnimator1.interpolator = LinearInterpolator()
        leftRotateAnimator2.interpolator = LinearInterpolator()
        leftRotateAnimator1.duration = 1000
        leftRotateAnimator1.start()
        leftBackImageButton.visibility = View.INVISIBLE
        leftFaceImageButton.visibility = View.VISIBLE
        val animatorSet = AnimatorSet()
        animatorSet.play(leftRotateAnimator2)
        animatorSet.play(leftRotateAnimator3)
        animatorSet.duration = 1000
        animatorSet.start()
    }

    fun onMiddleClick(view: View){
        val middleRotateAnimator1 = ObjectAnimator.ofFloat(middleBackImageButton, "rotationY", 0f, 90f)
        val middleRotateAnimator2 = ObjectAnimator.ofFloat(middleFaceImageButton, "rotationY", -90f, 0f)
        val middleRotateAnimator3 = ObjectAnimator.ofFloat(middleBackImageButton, "rotationY", 90f,0f)
        val animatorSet = AnimatorSet()
        animatorSet.play(middleRotateAnimator2)
        animatorSet.play(middleRotateAnimator3)
        middleRotateAnimator1.interpolator = LinearInterpolator()
        middleRotateAnimator2.interpolator = LinearInterpolator()
        middleRotateAnimator1.duration = 1000
        animatorSet.duration = 1000
        middleRotateAnimator1.start()
        middleBackImageButton.visibility = View.INVISIBLE
        middleFaceImageButton.visibility = View.VISIBLE
        animatorSet.start()
    }

    fun onRightClick(view: View){
        val rightRotateAnimator1 = ObjectAnimator.ofFloat(rightBackImageButton, "rotationY", 0f, 90f)
        val rightRotateAnimator2 = ObjectAnimator.ofFloat(rightFaceImageButton, "rotationY", -90f, 0f)
        val rightRotateAnimator3 = ObjectAnimator.ofFloat(rightBackImageButton, "rotationY", 90f,0f)
        val animatorSet = AnimatorSet()
        animatorSet.play(rightRotateAnimator2)
        animatorSet.play(rightRotateAnimator3)
        rightRotateAnimator1.interpolator = LinearInterpolator()
        rightRotateAnimator2.interpolator = LinearInterpolator()
        rightRotateAnimator1.duration = 1000
        animatorSet.duration = 1000
        rightRotateAnimator1.start()
        rightBackImageButton.visibility = View.INVISIBLE
        rightFaceImageButton.visibility = View.VISIBLE
        animatorSet.start()
    }
}