package com.insspring.poifox.storage

import com.insspring.poifox.model.UserModel
import io.realm.Realm
import io.realm.Realm.getDefaultInstance


class UserStorage {

    fun getRealmDefaultInstance(): Realm? {
        return getDefaultInstance()
    }

    fun closeRealm(): Unit? {
        return getDefaultInstance()?.close()
    }

    fun getUserByUsernameAndPassword(username: String, password: String): UserModel? {
        return getRealmDefaultInstance()?.where(UserModel::class.java)
            ?.equalTo("username", username)
            ?.equalTo("password", password)
            ?.findFirst()
    }

    fun getAllUsers(): MutableList<UserModel> {
        var userList : MutableList<UserModel> = mutableListOf()
        val realmList = getRealmDefaultInstance()?.where(UserModel::class.java)?.findAll()

        if (realmList != null) {
            userList = realmList.subList(0, realmList.size)
        }
        return userList
    }

}