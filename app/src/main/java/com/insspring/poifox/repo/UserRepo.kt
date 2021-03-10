package com.insspring.poifox.repo

import com.insspring.poifox.model.UserModel
import com.insspring.poifox.storage.UserStorage

open class UserRepo {

    private val userStorage = UserStorage()

    fun getUser(): UserModel? = userStorage.getUser()

    fun isUserInStorage(username: String, password: String): Boolean =
        userStorage.isUserInStorage(username, password)

    fun getAllUsers(): MutableList<UserModel> = userStorage.getAllUsers()

    fun saveUser(id: Int, username: String, password: String) =
        userStorage.saveUser(UserModel(id, username, password))

}