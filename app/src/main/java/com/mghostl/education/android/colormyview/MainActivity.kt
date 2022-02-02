package com.mghostl.education.android.colormyview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.mghostl.education.android.colormyview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var selectedViews = mutableSetOf<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setListeners()
    }


    private fun setListeners() {
        val clickableViews = listOf(binding.boxOneText, binding.boxTwoText, binding.boxThreeText,
        binding.boxFourText, binding.boxFiveText)
            .onEach { it.setOnClickListener { view ->
                if(selectedViews.contains(view)) {
                    selectedViews.remove(view)
                }
                else {
                    selectedViews.add(view)
                }} }


        listOf(binding.greenButton, binding.yellowButton, binding.redButton)
            .forEach { it.setOnClickListener { button ->
                selectedViews.forEach { view -> view.background = button.background }
                selectedViews.clear()
            } }

    }
}