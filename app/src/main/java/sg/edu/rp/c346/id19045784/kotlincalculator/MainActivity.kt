package sg.edu.rp.c346.id19045784.kotlincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var number = "0"
    var addNumber = 0.0
    var addBoolean = false
    var minusNumber = 0.0
    var minusBoolean = false
    var multiplyNumber = 0.0
    var multiplyBoolean = false
    var divideNumber = 0.0
    var divideBoolean = false
    var decimalNumber = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAC.setOnClickListener {
            tvNumber.text = 0.toString()
            number = ""
        }
    }


    fun NumOnClick(view: View){

        val btnSelected = view as Button
        when (btnSelected.id){
            btn0.id -> number += "0"
            btn1.id -> number += "1"
            btn2.id -> number += "2"
            btn3.id -> number += "3"
            btn4.id -> number += "4"
            btn5.id -> number += "5"
            btn6.id -> number += "6"
            btn7.id -> number += "7"
            btn8.id -> number += "8"
            btn9.id -> number += "9"
        }
        tvNumber.text = number

    }

    fun dotOnClick(view: View){
        if (!decimalNumber){
        tvNumber.text = "$number.0"

        }

    }

    fun addOnClick(view: View){
        val btnSelected = view as Button
        when (btnSelected.id){
            btnPlus.id -> addNumber = tvNumber.text.toString().toDouble()
        }
        addBoolean = true
        number = ""
        tvNumber.text = "0"
    }
    fun minusOnClick(view: View){
        val btnSelected = view as Button
        when (btnSelected.id){
            btnSub.id -> minusNumber = tvNumber.text.toString().toDouble()
        }
        minusBoolean = true
        number = ""
        tvNumber.text = "0"
    }
    fun multiplyOnClick(view: View){
        val btnSelected = view as Button
        when (btnSelected.id){
            btnMultiply.id -> multiplyNumber = tvNumber.text.toString().toDouble()
        }
        multiplyBoolean = true
        number = ""
        tvNumber.text = "0"
    }
    fun divideOnClick(view: View){
        val btnSelected = view as Button
        when (btnSelected.id){
            btnDivide.id -> divideNumber = tvNumber.text.toString().toDouble()
        }
        divideBoolean = true
        number = ""
        tvNumber.text = "0"
    }


    fun equalsOnClick(view: View){
        var result = 0
       // tvNumber.text = ""
        val btnSelected = view as Button
        if(addBoolean){
        when (btnSelected.id){
                btnEqual.id -> tvNumber.text = (tvNumber.text.toString().toInt() + addNumber).toString()

            }
        }
        else if (minusBoolean){

            when (btnSelected.id) {
               btnEqual.id -> tvNumber.text = (minusNumber - tvNumber.text.toString().toInt()).toString()

            }
        }
        else if (multiplyBoolean){

            when (btnSelected.id) {
                btnEqual.id -> tvNumber.text = (tvNumber.text.toString().toInt() * multiplyNumber).toString()

            }
        }
        else if (divideBoolean){
            var dividedResult = 0.0
            dividedResult = divideNumber /tvNumber.text.toString().toDouble()
                when (btnSelected.id) {
                    btnEqual.id -> tvNumber.text = dividedResult.toString()

                }
        }

        addBoolean = false
        minusBoolean = false
        multiplyBoolean = false
        divideBoolean = false
        number = ""
    }
}