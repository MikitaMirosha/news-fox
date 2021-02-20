package com.insspring.poifox.model

import io.realm.RealmModel
import io.realm.RealmObject

open class Register : RealmObject(), RealmModel {
    var username: String? = null
    var password: String? = null

    override fun toString(): String {
        return """User [username: $username, password: $password]"""
    }
}