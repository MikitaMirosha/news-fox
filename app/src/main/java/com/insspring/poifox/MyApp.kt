package com.insspring.poifox

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.rx.RealmObservableFactory

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initRealm()
    }

    private fun initRealm() {
        Realm.init(this@MyApp)
        val realmConfiguration = RealmConfiguration.Builder()
            .rxFactory(RealmObservableFactory(false))
            .deleteRealmIfMigrationNeeded()
            .allowWritesOnUiThread(true)
            .build()

        Realm.setDefaultConfiguration(realmConfiguration)
    }

}