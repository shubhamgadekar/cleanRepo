package com.alpha.cleanRepo.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alpha.cleanRepo.db.local.EntityDao
import com.alpha.cleanRepo.db.local.MyEntity
import com.alpha.cleanRepo.repository.MainRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeScreenViewModel @Inject constructor(
    private val inspectionRepository: MainRepository,
    private val entityDao: EntityDao
) :
    ViewModel() {

    private var _myEntityList = MutableStateFlow<List<String>>(emptyList())
    val myEntityList: StateFlow<List<String>> = _myEntityList


    init {
        viewModelScope.launch {
            getAllInspections()
        }
    }

    fun getAllInspections() {
        viewModelScope.launch {
             inspectionRepository.getMyEntityList().collect {
                 _myEntityList.emit(it!!)
            }
        }
    }
}
