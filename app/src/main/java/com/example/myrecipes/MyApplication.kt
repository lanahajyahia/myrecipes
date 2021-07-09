package com.example.myrecipes

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
// network model to tell hilt to inject retrofit instance
// tell hilt to provide a retofit builder to out datasource
@HiltAndroidApp
class MyApplication: Application() {
}