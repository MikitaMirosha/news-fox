package com.insspring.poifox.repo

import com.insspring.poifox.model.UserModel
import com.insspring.poifox.storage.UserStorage
import io.realm.Realm
import io.realm.kotlin.createObject

open class UserRepo {

    private val userStorage = UserStorage()

    fun getStorageInstance() = userStorage.getRealmDefaultInstance()


    fun getUserByUsernameAndPassword(username: String, password: String): UserModel? {
        return userStorage.getUserByUsernameAndPassword(username, password)
    }

    fun getAllUsers(): MutableList<UserModel> = userStorage.getAllUsers()


    fun saveUser(username: String?, password: String?): Boolean {
        return userStorage.saveUser(username, password)
    }

}