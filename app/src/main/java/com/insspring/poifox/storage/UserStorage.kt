package com.insspring.poifox.storage

import com.insspring.poifox.model.UserModel
import io.realm.Realm
import io.realm.Realm.getDefaultInstance
import io.realm.kotlin.createObject


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

    fun saveUser(username: String?, password: String?): Boolean {
        getRealmDefaultInstance()?.executeTransactionAsync { bgRealm ->
            val user: UserModel = bgRealm.createObject()
            user.username = username
            user.password = password
        }
        return true
    }

}