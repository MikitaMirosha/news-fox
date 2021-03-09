package com.insspring.poifox.repo

import com.insspring.poifox.model.UserModel
import com.insspring.poifox.storage.UserStorage
import io.realm.Realm
import io.realm.RealmModel

open class UserRepo {

    private val userStorage = UserStorage()

    fun getStorageInstance(): Realm? {
        return userStorage.getRealmDefaultInstance()
    }

    fun closeStorage(): Unit? {
        return userStorage.closeRealm()
    }

    fun getUser(username: String, password: String): UserModel? {
        return userStorage.getUser(username, password)
    }

    fun getAllUsers(): MutableSet<Class<out RealmModel>>? {
        return userStorage.getAllUsers()
    }

}