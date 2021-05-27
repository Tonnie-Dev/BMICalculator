package com.example.assignment_1

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.github.anastr.speedviewlib.SpeedView
import kotlin.math.absoluteValue


class MainActivity : AppCompatActivity() {

    private lateinit var bmi_meter: SpeedView
    private lateinit var spinner_units: Spinner
    private lateinit var number_picker_age: NumberPicker
    private lateinit var radio_grp_gender: RadioGroup
    private lateinit var seekbar_weight: SeekBar
    private lateinit var seekbar_height: SeekBar
    private lateinit var btn_reset: Button
    private lateinit var btn_calculate: Button
    private lateinit var text_weight_value: TextView
    private lateinit var text_height_value: TextView
    private lateinit var text_weight: TextView
    private lateinit var text_height: TextView

    var no: Int = 0
    private val WEIGHT = "weight"
    private val HEIGHT = "height"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setReferences()//Setup Gui Components
        show_seekbar_weight_value()//Show the seekbar value to textview(Weight)
        show_seekbar_height_value()//Show the seekbar value to textview(Height)
        setNumberPicker()//Setup the Number Picker for Max and Min for age
        setVariable()//Setup the text when selected different units
        ResetButton()//Setup the Reset Button

        SetBtnCalculate()
    }
    //This method is used to save the current state
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val seekbar1 = seekbar_weight.progress
        val seekbar2 = seekbar_height.progress

        outState.putInt(WEIGHT, seekbar1)
        outState.putInt(HEIGHT, seekbar2)

    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        //retrieve value using getInt() method
        val value = savedInstanceState.getInt(WEIGHT)
        seekbar_weight.progress = value
    }






    private fun SetBtnCalculate() {
        btn_calculate.setOnClickListener {
            //Declare all the variable into string
            val weight = Integer.parseInt(text_weight_value.text.toString())
            val height = Integer.parseInt(text_height_value.text.toString())
            val age = Integer.parseInt(number_picker_age.value.toString())
            val heightm = height.toDouble() / 100
            val spinnervalue = Integer.parseInt(spinner_units.selectedItemPosition.toString())
            val gender = Integer.parseInt(radio_grp_gender.checkedRadioButtonId.toString())

            //When user are not select the weight or height will be make a toast
            if ((weight == 0) || (height == 0)) {
                Toast.makeText(
                    this, getString(R.string.toast_message_weight_height),
                    Toast.LENGTH_LONG
                ).show()
            } else {
                //Calculate the BMI with different formula
                if (spinnervalue == 0) {
                    val bmi = weight / (heightm * heightm)
                    bmi_meter.speedTo(bmi.toFloat())

                    //The BMI Categorization for Male (Age 2-20)
                    if ((age == 2) || (gender == 0)) {
                        when {
                            bmi <= 14.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 18.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 19.3 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 3) || (gender == 0)) {
                        when {
                            bmi <= 14.2 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 17.2 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 18.2 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 4) || (gender == 0)) {
                        when {
                            bmi <= 13.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 16.8 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 17.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 5) || (gender == 0)) {
                        when {
                            bmi <= 13.8 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 16.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 17.8 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 6) || (gender == 0)) {
                        when {
                            bmi <= 13.6 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 16.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 18.3 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 7) || (gender == 0)) {
                        when {
                            bmi <= 13.6 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 17.3 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 19.0 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 8) || (gender == 0)) {
                        when {
                            bmi <= 13.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 17.8 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 19.4 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 9) || (gender == 0)) {
                        when {
                            bmi <= 13.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 18.5 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 20.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 10) || (gender == 0)) {
                        when {
                            bmi <= 14.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 19.3 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 22.0 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 11) || (gender == 0)) {
                        when {
                            bmi <= 14.4 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 20.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 22.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 12) || (gender == 0)) {
                        when {
                            bmi <= 14.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 20.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 24.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 13) || (gender == 0)) {
                        when {
                            bmi <= 15.3 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 21.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 25.0 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 14) || (gender == 0)) {
                        when {
                            bmi <= 15.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 22.5 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 25.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 15) || (gender == 0)) {
                        when {
                            bmi <= 16.4 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 23.3 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 26.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 16) || (gender == 0)) {
                        when {
                            bmi <= 17.0 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 24.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 17.4 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 17) || (gender == 0)) {
                        when {
                            bmi <= 17.5 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 24.8 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 28.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 18) || (gender == 0)) {
                        when {
                            bmi <= 18.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 25.5 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 28.8 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 19) || (gender == 0)) {
                        when {
                            bmi <= 18.6 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 26.2 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 29.6 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 20) || (gender == 0)) {
                        when {
                            bmi <= 19.0 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 26.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 30.5 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                    //The BMI Categorization for Female (Age 2-20)
                    else if ((age == 2) || (gender == 1)) {
                        when {
                            bmi <= 14.3 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 19.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 19.0 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 3) || (gender == 1)) {
                        when {
                            bmi <= 12.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 16.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 18.2 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 4) || (gender == 1)) {
                        when {
                            bmi <= 12.6 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 16.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 17.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 5) || (gender == 1)) {
                        when {
                            bmi <= 13.4 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 15.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 18.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 6) || (gender == 1)) {
                        when {
                            bmi <= 13.3 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 17.0 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 18.2 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 7) || (gender == 1)) {
                        when {
                            bmi <= 13.3 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 17.5 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 19.5 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 8) || (gender == 1)) {
                        when {
                            bmi <= 13.4 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 18.2 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 20.5 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 9) || (gender == 1)) {
                        when {
                            bmi <= 13.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 18.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 21.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 10) || (gender == 1)) {
                        when {
                            bmi <= 13.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 19.8 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 22.8 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 11) || (gender == 1)) {
                        when {
                            bmi <= 14.3 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 20.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 24.0 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 12) || (gender == 1)) {
                        when {
                            bmi <= 13.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 19.8 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 22.8 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 13) || (gender == 1)) {
                        when {
                            bmi <= 15.2 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 22.4 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 26.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 14) || (gender == 1)) {
                        when {
                            bmi <= 15.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 23.2 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 27.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 15) || (gender == 1)) {
                        when {
                            bmi <= 16.2 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 23.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 28.0 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 16) || (gender == 1)) {
                        when {
                            bmi <= 16.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 24.5 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 28.8 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 17) || (gender == 1)) {
                        when {
                            bmi <= 17.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 25.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 29.5 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 18) || (gender == 1)) {
                        when {
                            bmi <= 17.5 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 25.6 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 30.2 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 19) || (gender == 1)) {
                        when {
                            bmi <= 17.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 26.0 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 20.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 20) || (gender == 1)) {
                        when {
                            bmi <= 17.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 26.4 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 31.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                    //The BMI Categorization for Adult (Age 21 and above)
                    else if (age >= 20) {
                        if (bmi <= 14.9) {
                            Toast.makeText(
                                this,
                                getString(R.string.toast_message_adult_VS_underweight),
                                Toast.LENGTH_LONG
                            ).show()
                        } else if (bmi <= 16.9) {
                            Toast.makeText(
                                this,
                                getString(R.string.toast_message_adult_S_underweight),
                                Toast.LENGTH_LONG
                            ).show()
                        } else if (bmi <= 18.4) {
                            Toast.makeText(
                                this,
                                getString(R.string.toast_message_adult_underweight),
                                Toast.LENGTH_LONG
                            ).show()
                        } else if (bmi <= 24.9) {
                            Toast.makeText(
                                this,
                                getString(R.string.toast_message_adult_normal),
                                Toast.LENGTH_LONG
                            ).show()
                        } else if (bmi <= 29.9) {
                            Toast.makeText(
                                this,
                                getString(R.string.toast_message_adult_overweight),
                                Toast.LENGTH_LONG
                            ).show()
                        } else if (bmi <= 34.9) {
                            Toast.makeText(
                                this,
                                getString(R.string.toast_message_adult_M_Moderately),
                                Toast.LENGTH_LONG
                            ).show()
                        } else if (bmi <= 39.9) {
                            Toast.makeText(
                                this,
                                getString(R.string.toast_message_adult_S_obse),
                                Toast.LENGTH_LONG
                            ).show()
                        } else Toast.makeText(
                            this,
                            getString(R.string.toast_message_adult_VS_obese),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else {
                    val bmi = 703 * weight / (height * height)
                    bmi_meter.speedTo(bmi.toFloat())


                    //The BMI Categorization for Male (Age 2-20)
                    if ((age == 2) || (gender == 0)) {
                        when {
                            bmi <= 14.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 18.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 19.3 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 3) || (gender == 0)) {
                        when {
                            bmi <= 14.2 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 17.2 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 18.2 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 4) || (gender == 0)) {
                        when {
                            bmi <= 13.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 16.8 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 17.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 5) || (gender == 0)) {
                        when {
                            bmi <= 13.8 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 16.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 17.8 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 6) || (gender == 0)) {
                        when {
                            bmi <= 13.6 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 16.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 18.3 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 7) || (gender == 0)) {
                        when {
                            bmi <= 13.6 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 17.3 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 19.0 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 8) || (gender == 0)) {
                        when {
                            bmi <= 13.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 17.8 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 19.4 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 9) || (gender == 0)) {
                        when {
                            bmi <= 13.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 18.5 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 20.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 10) || (gender == 0)) {
                        when {
                            bmi <= 14.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 19.3 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 22.0 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 11) || (gender == 0)) {
                        when {
                            bmi <= 14.4 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 20.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 22.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 12) || (gender == 0)) {
                        when {
                            bmi <= 14.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 20.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 24.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 13) || (gender == 0)) {
                        when {
                            bmi <= 15.3 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 21.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 25.0 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 14) || (gender == 0)) {
                        when {
                            bmi <= 15.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 22.5 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 25.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 15) || (gender == 0)) {
                        when {
                            bmi <= 16.4 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 23.3 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 26.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 16) || (gender == 0)) {
                        when {
                            bmi <= 17.0 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 24.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 17.4 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 17) || (gender == 0)) {
                        when {
                            bmi <= 17.5 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 24.8 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 28.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 18) || (gender == 0)) {
                        when {
                            bmi <= 18.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 25.5 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 28.8 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 19) || (gender == 0)) {
                        when {
                            bmi <= 18.6 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 26.2 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 29.6 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 20) || (gender == 0)) {
                        when {
                            bmi <= 19.0 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 26.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 30.5 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                    //The BMI Categorization for Female (Age 2-20)
                    else if ((age == 2) || (gender == 1)) {
                        when {
                            bmi <= 19.0 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 26.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 30.5 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 2) || (gender == 1)) {
                        when {
                            bmi <= 14.3 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 19.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 19.0 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 3) || (gender == 1)) {
                        when {
                            bmi <= 12.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 16.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 18.2 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 4) || (gender == 1)) {
                        when {
                            bmi <= 12.6 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 16.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 17.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 5) || (gender == 1)) {
                        when {
                            bmi <= 13.4 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 15.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 18.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 6) || (gender == 1)) {
                        when {
                            bmi <= 13.3 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 17.0 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 18.2 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 7) || (gender == 1)) {
                        when {
                            bmi <= 13.3 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 17.5 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 19.5 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 8) || (gender == 1)) {
                        when {
                            bmi <= 13.4 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 18.2 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 20.5 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 9) || (gender == 1)) {
                        when {
                            bmi <= 13.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 18.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 21.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 10) || (gender == 1)) {
                        when {
                            bmi <= 13.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 19.8 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 22.8 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 11) || (gender == 1)) {
                        when {
                            bmi <= 14.3 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 20.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 24.0 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 12) || (gender == 1)) {
                        when {
                            bmi <= 13.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 19.8 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 22.8 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 13) || (gender == 1)) {
                        when {
                            bmi <= 15.2 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 22.4 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 26.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 14) || (gender == 1)) {
                        when {
                            bmi <= 15.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 23.2 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 27.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 15) || (gender == 1)) {
                        when {
                            bmi <= 16.2 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 23.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 28.0 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 16) || (gender == 1)) {
                        when {
                            bmi <= 16.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 24.5 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 28.8 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 17) || (gender == 1)) {
                        when {
                            bmi <= 17.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 25.1 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 29.5 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 18) || (gender == 1)) {
                        when {
                            bmi <= 17.5 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 25.6 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 30.2 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 19) || (gender == 1)) {
                        when {
                            bmi <= 17.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 26.0 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 20.9 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else if ((age == 20) || (gender == 1)) {
                        when {
                            bmi <= 17.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_underweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 26.4 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_healthy_age),
                                Toast.LENGTH_LONG
                            ).show()
                            bmi <= 31.7 -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_overweight_age),
                                Toast.LENGTH_LONG
                            ).show()
                            else -> Toast.makeText(
                                this,
                                getString(R.string.toast_message_obesity_age),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                    //The BMI Categorization for Adult (Age 21 and above)
                    else if (age >= 20) {
                        if (bmi <= 14.9) {
                            Toast.makeText(
                                this,
                                getString(R.string.toast_message_adult_VS_underweight),
                                Toast.LENGTH_LONG
                            ).show()
                        } else if (bmi <= 16.9) {
                            Toast.makeText(
                                this,
                                getString(R.string.toast_message_adult_S_underweight),
                                Toast.LENGTH_LONG
                            ).show()
                        } else if (bmi <= 18.4) {
                            Toast.makeText(
                                this,
                                getString(R.string.toast_message_adult_underweight),
                                Toast.LENGTH_LONG
                            ).show()
                        } else if (bmi <= 24.9) {
                            Toast.makeText(
                                this,
                                getString(R.string.toast_message_adult_normal),
                                Toast.LENGTH_LONG
                            ).show()
                        } else if (bmi <= 29.9) {
                            Toast.makeText(
                                this,
                                getString(R.string.toast_message_adult_overweight),
                                Toast.LENGTH_LONG
                            ).show()
                        } else if (bmi <= 34.9) {
                            Toast.makeText(
                                this,
                                getString(R.string.toast_message_adult_M_Moderately),
                                Toast.LENGTH_LONG
                            ).show()
                        } else if (bmi <= 39.9) {
                            Toast.makeText(
                                this,
                                getString(R.string.toast_message_adult_S_obse),
                                Toast.LENGTH_LONG
                            ).show()
                        } else Toast.makeText(
                            this,
                            getString(R.string.toast_message_adult_VS_obese),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }

        }
    }
    private fun ResetButton() {
        //Clink on the reset button all will be reset
        btn_reset.setOnClickListener {
            text_weight.text = "Weight (kg)"
            text_height.text = "Height (cm)"
            seekbar_weight.max = 450
            seekbar_height.max = 250
            seekbar_weight.progress = 0
            seekbar_height.progress = 0
            text_height_value.text = "0"
            text_weight_value.text = "0"
            number_picker_age.value = 2
            spinner_units.setSelection(0)
            (radio_grp_gender.getChildAt(0) as RadioButton).isChecked = true
            bmi_meter.speedTo(0F)
        }
    }

    private fun setVariable() {
        //Set the text of units and the max progress
        spinner_units.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position == 0) {
                    text_weight.text = "Weight (kg)"
                    text_height.text = "Height (cm)"
                    seekbar_weight.max = 450
                    seekbar_height.max = 250
                    seekbar_weight.progress = 0
                    seekbar_height.progress = 0
                    text_height_value.text = "0"
                    text_weight_value.text = "0"
                    number_picker_age.value = 2
                    bmi_meter.speedTo(0F)
                } else if (position == 1) {
                    text_weight.text = "Weight (ibs)"
                    text_height.text = "Height (in)"
                    seekbar_weight.max = 770
                    seekbar_height.max = 80
                    text_height_value.text = "0"
                    text_weight_value.text = "0"
                    seekbar_weight.progress = 0
                    seekbar_height.progress = 0
                    number_picker_age.value = 2
                    bmi_meter.speedTo(0F)
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }

    private fun setNumberPicker() {
        //Set the Number Picker Max and Min for age
        number_picker_age.minValue = 2
        number_picker_age.maxValue = 150
    }

    private fun setReferences() {
        //Set the References
        bmi_meter = findViewById(R.id.bmi_meter)
        spinner_units = findViewById(R.id.spinner_unit)
        number_picker_age = findViewById(R.id.number_picker_age)
        radio_grp_gender = findViewById(R.id.radio_grp_gender)
        seekbar_weight = findViewById(R.id.seekbar_weight)
        seekbar_height = findViewById(R.id.seekbar_height)
        btn_calculate = findViewById(R.id.btn_calculate)
        btn_reset = findViewById(R.id.btn_reset)
        text_weight_value = findViewById(R.id.text_weight_value)
        text_height_value = findViewById(R.id.text_height_value)
        text_height = findViewById(R.id.text_height)
        text_weight = findViewById(R.id.text_weight)
        text_height_value.text = "0"
        text_weight_value.text = "0"

    }

    private fun show_seekbar_weight_value() {
        //Get the seekbar progress to show out to textview(Weight)
        seekbar_weight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                text_weight_value.text = "$progress"

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }

    private fun show_seekbar_height_value() {
        //Get the seekbar progress to show out to textview(Height)
        seekbar_height.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                text_height_value.text = "$progress"

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }



    }

