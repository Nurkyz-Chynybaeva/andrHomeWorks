package com.example.andrhomeworks

import java.util.*


fun findMaxVowels(text: Collection<String>): String? {
    var best: String? = null
    var max = 0
    for (line in text) {
        // may need a better definition of "word"
        for (word in line.split("\\s+").toTypedArray()) {
            val count = countChars(word.lowercase(Locale.getDefault()), "aeiou")
            if (count > max) {
                max = count
                best = word
            }
        }
    }
    return best
}

fun countChars(text: String, chars: String): Int {
    var count = 0
    for (c in text.toCharArray()) if (chars.indexOf(c) >= 0) count += 1
    return count
}