package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initViews()
    }


    /**
     * Add onClickListeners to the higher, lower and reset buttons.
     * Set the initial (UI) state of the game.

     */

    private fun initViews() {
        //click listener for lower button
        lowerB.setOnClickListener {
            onLowerClick()
        }
        //click listener for equal button
        equalB.setOnClickListener {
            onEqualClick()
        }
        //click listener for higher button
        higherB.setOnClickListener {
            onHigherClick()
        }

        updateUI()
    }

    /**
     * Update the last throw text and the dice image resource drawable with the current throw.
     */

    private fun updateUI() {
        lastThrowText.text = getString(R.string.last_throw, lastThrow)

        //hier word gekeken welke img bij de currentThrow hoort
        when(currentThrow) {
            1 -> Dice.setImageResource(R.drawable.dice1)
            2 -> Dice.setImageResource(R.drawable.dice2)
            3 -> Dice.setImageResource(R.drawable.dice3)
            4 -> Dice.setImageResource(R.drawable.dice4)
            5 -> Dice.setImageResource(R.drawable.dice5)
            6 -> Dice.setImageResource(R.drawable.dice6)


        }

    }


    /**
     * Replaces the previous dice value with the current one and replaces the current dice with a new dice
     * with a random number between 1 and 6 (inclusive).
     */

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()

    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onHigherClick() {
        rollDice()

        if (currentThrow > lastThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onLowerClick() {
        rollDice()

        if (currentThrow < lastThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onEqualClick() {
        rollDice()

        if (currentThrow == lastThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    /**
     * Displays a successful Toast message.
     */
    private fun onAnswerCorrect() {
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_SHORT).show()
    }

    /**
     * Displays a incorrect Toast message.
     */
    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_SHORT).show()
    }





}
