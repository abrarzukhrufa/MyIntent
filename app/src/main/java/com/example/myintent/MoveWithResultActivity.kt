package com.example.myintent

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.coba.MainActivity


class MoveWithResultActivity : AppCompatActivity() {
    private lateinit var radioGroup: RadioGroup
    private lateinit var btnpilih: Button
    @SuppressLint("ResourceType", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_result)
        radioGroup = findViewById(R.id.radiogrup)
        btnpilih = findViewById(R.id.pilih_result)
        btnpilih.setOnClickListener {
            val bundle = Bundle()
            val selectedID: Int = radioGroup.checkedRadioButtonId
            if (selectedID != 1) {
                val radio: RadioButton = findViewById(selectedID)

                bundle.putString("inputText", radio.text.toString())
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)

            }

        }
    }
}