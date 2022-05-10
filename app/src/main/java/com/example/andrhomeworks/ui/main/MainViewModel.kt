package com.example.andrhomeworks.ui.main


import android.app.Application
import androidx.lifecycle.*
import com.example.andrhomeworks.R
import com.example.andrhomeworks.data.models.CharacterEntity
import com.example.andrhomeworks.domain.use_case.GetAllCharactersUseCase
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
    private val getAllCharactersUseCase: GetAllCharactersUseCase,
    private val getEpisodeAsLiveDataUseCase: GetCharactersAsLiveDataUseCase
) : ViewModel() {

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
            getAllCharactersUseCase()
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

    fun getCharacterByIndex(index: Int): CharacterEntity? {
        return charactersLiveData.value?.get(index)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}