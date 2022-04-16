package com.example.andrhomeworks.ui

import androidx.annotation.StringRes
import com.example.andrhomeworks.data.models.CharacterEntity

sealed class Event(){
    class ShowToast(@StringRes val resId: Int): Event()
    object ShowLoadingToast: Event()
    object ShowFinishedLoadingToast: Event()
    class FetchedCharacter(val character: CharacterEntity): Event()
}