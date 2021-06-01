package com.example.android.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.android.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Data binding generated the binding object at compile time for all views in the layout
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //// When the Done button is clicked,
        //findViewById<Button>(R.id.done_button).setOnClickListener {
        //    addNickname(it)
        //}

        // Through data binding, we get the Done button from activity_main.xml
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    /**
     * Set nickname TextView to EditText, Make the TextView visible and hide the button and EditText
     */
    fun addNickname(view: View) {
        //// Get the nickname EditText and TextView
        //// Note: we are only calling these once, so we don't save them as field variables to save memory
        //val nicknameEdit: EditText = findViewById(R.id.nickname_edit)
        //val nicknameText: TextView = findViewById(R.id.nickname_text)

        // We can use .apply {} to apply the data binding to all objects
        binding.apply {
            // Set the TextView to the EditText
            nicknameText.text = nicknameEdit.text

            // Make the TextView visible
            // Hide the button and EditView
            view.visibility = View.GONE
            nicknameEdit.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // Hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}