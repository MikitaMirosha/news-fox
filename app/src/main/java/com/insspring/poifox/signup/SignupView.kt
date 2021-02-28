package com.insspring.poifox.signup

import com.delivery.ui.base.BaseMvpView

interface SignupView : BaseMvpView {
    fun openLoginActivity()
    fun updateTitleName()
}