package com.insspring.poifox.repo

import com.insspring.poifox.model.UserModel
import com.insspring.poifox.storage.UserStorage
import io.realm.Realm

open class UserRepo {

    private val userStorage = UserStorage()

    fun getUser(): UserModel {
        return UserModel()
    }

    open fun getStorageInstance(): Realm? {
        return userStorage.getRealmDefaultInstance()
    }

    fun getAllUsers(): MutableList<UserModel> {
        return mutableListOf(UserModel())
    }
}