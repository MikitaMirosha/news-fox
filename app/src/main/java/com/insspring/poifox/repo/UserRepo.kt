package com.insspring.poifox.repo

import com.insspring.poifox.model.UserModel
import com.insspring.poifox.storage.UserStorage

open class UserRepo {

    private val userStorage = UserStorage()

    fun getUserStorage() = userStorage.getUserStorage()

    fun getUser(): UserModel? = userStorage.getUser()

    fun isUserLoggedIn(username: String, password: String): Boolean =
        userStorage.isUserInStorage(username, password)

    fun getAllUsers(): MutableList<UserModel> = userStorage.getAllUsers()

    fun saveUser(id: Int, username: String, password: String) =
        userStorage.saveUser(UserModel(id, username, password))

}