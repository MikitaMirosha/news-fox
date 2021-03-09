package com.insspring.poifox.storage

import com.insspring.poifox.model.UserModel
import io.realm.Realm
import io.realm.Realm.getDefaultInstance
import io.realm.RealmModel


class UserStorage {

    fun getRealmDefaultInstance(): Realm? {
        return getDefaultInstance()
    }

    fun closeRealm(): Unit? {
        return getDefaultInstance()?.close()
    }

    fun getUser(username: String, password: String): UserModel? {
        return getRealmDefaultInstance()?.where(UserModel::class.java)
            ?.equalTo("username", username)
            ?.equalTo("password", password)
            ?.findFirst()
    }

    fun getAllUsers(): MutableSet<Class<out RealmModel>>? {
        return getRealmDefaultInstance()?.configuration?.realmObjectClasses
    }

}