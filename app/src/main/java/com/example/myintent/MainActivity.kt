package com.example.coba

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SimpleCursorAdapter.ViewBinder
import android.widget.TextView
import com.example.myintent.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvinputText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val   btnMoveActivity: Button =
            findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithDataActivity : Button =
            findViewById(R.id.btn_move_with_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnDialPhone: Button =
            findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnMoveWithObjectActivity : Button =
            findViewById(R.id.btn_move_with_object)
        btnMoveWithObjectActivity.setOnClickListener(this)

        val btnMoveWithResultActivity : Button =
            findViewById(R.id.btn_move_with_result)
        btnMoveWithResultActivity.setOnClickListener(this)

        tvinputText = findViewById(R.id.tv_result)

        if (intent.extras != null)
        {
            val bundle = intent.extras
            tvinputText.setText(bundle?.getString("inputText"))
        }else{
            tvinputText.setText(intent.getStringExtra("inputText"))
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_with_data -> {
                val moveWithDataIntent = Intent(this@MainActivity,
                    MoveWithDataActivity::class.java)

                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME,
                    "SAM")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE,
                    5)
                startActivity(moveWithDataIntent)
            }
            R.id.btn_dial_number -> {
                val phoneNumber = "089601112937"

                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: $phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_move_with_object -> {
                val person = Person("Rafif", "hakimatahallah768@gmail.com", "Kediri")
                val moveWithObjectIntent = Intent (this@MainActivity,
                    MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }
            R.id.btn_move_with_result -> {
                val moveWithResultIntent = Intent(this@MainActivity, MoveWithResultActivity::class.java)
                startActivity(moveWithResultIntent)
            }
        }
    }
}
