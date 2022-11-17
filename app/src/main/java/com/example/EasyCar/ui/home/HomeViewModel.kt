package com.example.EasyCar.ui.home

import androidx.lifecycle.*
import com.example.EasyCar.data.CarDao
import com.example.EasyCar.model.Car

class HomeViewModel(private val CarDao: CarDao) : ViewModel() {
    val allCars: LiveData<List<Car>> = CarDao.getCars().asLiveData()

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}
class HomeViewModelFactory(private val CarDao: CarDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(CarDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}