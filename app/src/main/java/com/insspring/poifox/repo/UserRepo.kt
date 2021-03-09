package com.insspring.poifox.repo

import com.insspring.poifox.model.UserModel
import com.insspring.poifox.storage.UserStorage
import io.realm.Realm

open class UserRepo {

    private val userStorage = UserStorage()

    fun getStorageInstance(): Realm? {
        return userStorage.getRealmDefaultInstance()
    }

    fun getUserByUsernameAndPassword(username: String, password: String): UserModel? {
        return userStorage.getUserByUsernameAndPassword(username, password)
    }

    fun getAllUsers(): MutableList<UserModel> {
        return userStorage.getAllUsers()
    }

}