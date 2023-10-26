package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) { typedArray.getResourceId(it, 0) }
        typedArray.recycle()

        val imageDisplayFragment = ImageDisplayFragment.newInstance(imageArray)

        if (supportFragmentManager.findFragmentById(R.id.fragment_container) !is ImageDisplayFragment)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, imageDisplayFragment)
                .addToBackStack(null)
                .setReorderingAllowed(true)
                .commit()

    }
}

