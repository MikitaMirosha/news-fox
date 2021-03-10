package com.insspring.poifox.storage

import com.insspring.poifox.model.UserModel
import com.insspring.poifox.utils.extensions.execute
import io.realm.Realm
import io.realm.kotlin.where


class UserStorage {

    fun getUserStorage(): Realm = Realm.getDefaultInstance()

    fun getUser(): UserModel? {
        Realm.getDefaultInstance().use {
            return it.where(UserModel::class.java).findFirst()
        }
    }

    fun isUserInStorage(username: String, password: String): Boolean {
        val user: UserModel? = getUserStorage().where(UserModel::class.java)
            ?.equalTo("username", username)
            ?.equalTo("password", password)
            ?.findFirst()

        return user != null
    }

    fun getAllUsers(): MutableList<UserModel> {
        Realm.getDefaultInstance().use {
            return it.where<UserModel>().findAll().toMutableList()
        }
    }

    fun saveUser(user: UserModel) {
        getUserStorage().execute {
            it.insertOrUpdate(user)
        }
    }

    fun closeRealm(): Unit? = Realm.getDefaultInstance()?.close()

}