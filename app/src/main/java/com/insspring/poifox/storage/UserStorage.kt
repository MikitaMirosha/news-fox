package com.insspring.poifox.storage

import io.realm.Realm

class UserStorage {

    fun getRealmDefaultInstance(): Realm? {
        return Realm.getDefaultInstance()
    }

}