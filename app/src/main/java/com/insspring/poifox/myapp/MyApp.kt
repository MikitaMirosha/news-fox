package com.insspring.poifox.myapp

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.rx.RealmObservableFactory

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initRealm()
        configRealm()
    }

    private fun initRealm() {
        Realm.init(this@MyApp)
    }

    private fun configRealm() {
        val realmConfiguration = RealmConfiguration.Builder()
            .rxFactory(RealmObservableFactory(false))
            .deleteRealmIfMigrationNeeded()
            .allowWritesOnUiThread(true)
            .build()

        Realm.setDefaultConfiguration(realmConfiguration)
    }
}