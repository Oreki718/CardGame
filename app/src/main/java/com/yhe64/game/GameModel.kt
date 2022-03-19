package com.yhe64.game

import com.yhe64.game.Ace.Companion.randomAce
import kotlin.random.Random.Default.nextInt

enum class Ace {
    LEFT, MIDDLE, RIGHT;

    companion object{
        fun randomAce(): Ace{
            return values()[nextInt(values().size)]
        }
    }
}

enum class Card {
    BACK, BLANK, ACE
}

class GameModel(
    var left: Card = Card.BACK,
    var middle: Card = Card.BACK,
    var right: Card = Card.BACK,
    var ace : Ace = Ace.LEFT){

    fun playGame(){
        left = Card.BLANK
        middle = Card.BLANK
        right = Card.BLANK
        ace = randomAce()
        when (ace){
            Ace.LEFT -> left = Card.ACE
            Ace.MIDDLE -> middle = Card.ACE
            Ace.RIGHT -> right = Card.ACE
        }
    }

    fun resetGame(){
        left = Card.BACK
        right = Card.BACK
        middle = Card.BACK
        ace = Ace.LEFT
    }

}