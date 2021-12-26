package com.example.andrhomeworks

import java.util.regex.Matcher
import java.util.regex.Pattern


fun main(args: String) {
    val text = "Егор Алла Анна"
    val pattern: Pattern = Pattern.compile("А.+?а")
    val matcher: Matcher = pattern.matcher(text)
    while (matcher.find()) {
        val start: Int = matcher.start()
        val end: Int = matcher.end()
        println(
            "Найдено совпадение " + text.substring(
                start,
                end
            ) + " с " + start + " по " + (end - 1) + " позицию"
        )
    }
    println(matcher.replaceFirst("Ира"))
    println(matcher.replaceAll("Ольга"))
    println(text)
}