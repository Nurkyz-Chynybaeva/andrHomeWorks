package com.example.andrhomeworks

import java.util.*

fun main(args: Array<String>) {
    val `in` = Scanner(System.`in`)
    println("enter a sentence")
    val w = `in`.nextLine() + " "
    var z = ""
    val v = "aА"
    var ww = ""
    var cc = 0
    var cl = 0
    for (element in w) {
        val c = element
        if (c.code != 2) z += c else {
            for (element in w) {
                val d = element
                if (v.indexOf(d) != -1) cc++
            }
            if (cc > cl) {
                ww = z
                cl = cc
            }
            z = ""
            cc = 0
        }
    }
    println("res is :$ww")
    println("it has" + cl + "no is vowels")
}
