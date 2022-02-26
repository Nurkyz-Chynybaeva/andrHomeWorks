package com.example.andrhomeworks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.andrhomeworks.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btn.setOnClickListener {
                val eTxt = edit.text.toString().trim().split("\\s+".toRegex())
                var count = 0
                eTxt.forEach {
                    if (it.count() == 3) {
                        count += 1
                    } else 0
                }
                txt.text = count.toString()

//                val i = if (eTxt.isEmpty()) 0 else eTxt.split("\\s+".toRegex()).size
//                txt.text = i.toString()
            }
        }
    }

}



//fun main(args: Array<String>) {
//    // TODO Auto-generated method stub
//    val input = Scanner(System.`in`)
//    println("Input a string:")
//    val s: String
//    s = input.nextLine()
//    val strings = s.split(" ").toTypedArray()
//    val counts = IntArray(4)
//    for (str in strings) if (str.length < counts.size) counts[str.length] += 1
//    for (i in 1 until counts.size) println(i.toString() + " letter words: " + counts[i])
//    input.close()
//
//    // TODO Auto-generated method stub
//} //end main
//




