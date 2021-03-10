package com.insspring.poifox.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class UserModel(
    @PrimaryKey
    var id: Int = -1,
    var username: String? = null,
    var password: String? = null
) : RealmObject()