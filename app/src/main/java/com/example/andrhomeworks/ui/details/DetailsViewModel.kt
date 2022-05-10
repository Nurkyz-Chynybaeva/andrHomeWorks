package com.example.andrhomeworks.ui.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andrhomeworks.domain.use_case.GetCharacterUseCase
import com.example.andrhomeworks.ui.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getCharacterByIdUseCase: GetCharacterUseCase

) : ViewModel() {

    private val disposable: CompositeDisposable = CompositeDisposable()
    private var id: Long = -1

    private val _event = MutableLiveData<Event?>()
    val event: LiveData<Event?>
        get() = _event

//    val liveCharacter = MutableLiveData<Character>()

    fun setId(id: Long) {
        this.id = id
    }

    fun fetchCharacter() {
        disposable.add(
            getCharacterByIdUseCase(id)
                .subscribe({
                    _event.value = Event.FetchedCharacter(it)
//                           liveCharacter.value = it
                }, {

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}