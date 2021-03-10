package com.insspring.poifox.utils.extensions

import android.view.View
import io.realm.Realm

fun Realm.execute(block: (realm: Realm) -> Unit) {
    this.use {
        it.executeTransaction { realm ->
            block(realm)
        }
    }
}

fun View.show() {
    if (this.visibility != View.VISIBLE)
        this.visibility = View.VISIBLE
}

fun View.hide() {
    if (this.visibility != View.GONE)
        this.visibility = View.GONE
}