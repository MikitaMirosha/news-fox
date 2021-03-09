package com.insspring.poifox.myapp

import android.app.Application
import io.realm.Realm

<<<<<<< HEAD
=======

>>>>>>> origin
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}