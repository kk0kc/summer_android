package com.example.imtrying

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    private var string: String = ""
        set(value) {
            field = if (value.equals("not")) "Данные введены некорректно"
                    else "Ответ: &value"
            result?.text = field
        }
    private var result: TextView? = null
    private var name: EditText? = null
    private var height: EditText? = null
    private var weight: EditText? = null
    private var year: EditText? = null
    private var button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        result = findViewById(R.id.textView2)
        name = findViewById(R.id.editTextTextPersonName2)
        height = findViewById(R.id.editTextTextPersonName)
        weight = findViewById(R.id.editTextTextPersonName3)
        year = findViewById(R.id.editTextTextPersonName4)
        button = findViewById(R.id.button)
        button?.setOnClickListener{PressButton()}
    }
    fun PressButton() {

        string = try {
            val name2: String = name?.text.toString()
            val height2 = height?.text.toString().toInt()
            val weight2 = weight?.text.toString().toDouble()
            val year2 = year?.text.toString().toInt()
            if(name2.length in 1..50 && height2 in 1..249 && weight2 > 0 && weight2 < 250 && year2 in 1..149){
                name2 + " " + (height2*weight2 - year2)}
            else {"not"}} catch (e:NumberFormatException){
                "not"
        }
    }

}