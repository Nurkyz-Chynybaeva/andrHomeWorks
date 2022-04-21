package com.example.andrhomeworks.ui.main


import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.andrhomeworks.App
import com.example.andrhomeworks.R
import com.example.andrhomeworks.data.models.CharacterEntity
import com.example.andrhomeworks.data.repo.Repo
import com.example.andrhomeworks.domain.use_case.GetAllCharacters
import com.example.andrhomeworks.domain.use_case.GetCharactersAsLiveDataUseCase
import com.example.andrhomeworks.ui.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val getEpisodeUseCase: GetAllCharacters,
    private val getEpisodeAsLiveDataUseCase: GetCharactersAsLiveDataUseCase

) : AndroidViewModel(application) {

    private val disposable: CompositeDisposable = CompositeDisposable()
    val charactersLiveData: LiveData<List<CharacterEntity>> = getEpisodeAsLiveDataUseCase()

    private val _event = MutableLiveData<Event?>()
    val event: LiveData<Event?>
        get() = _event

    init {
        loadCharacters()
    }

    fun loadCharacters() {
        _event.value = Event.ShowLoadingToast
        disposable.add(
            getEpisodeUseCase()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate { _event.value = Event.ShowFinishedLoadingToast }
                .subscribe({

                }, {
                    handleError(it)
                })
        )
    }

    private fun handleError(it: Throwable) {
        _event.value = when (it) {
            is UnknownHostException -> Event.ShowToast(R.string.no_internet)
            else -> Event.ShowToast(R.string.unknown_error)
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}