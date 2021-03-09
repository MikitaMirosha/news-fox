package com.insspring.poifox.model

import io.realm.RealmModel
import io.realm.RealmObject

open class Register : RealmObject(), RealmModel {
    var username: String? = null
    var password: String? = null
}