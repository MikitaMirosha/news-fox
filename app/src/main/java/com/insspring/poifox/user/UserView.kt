package com.insspring.poifox.user

import com.insspring.poifox.ui.base.BaseMvpView

interface UserView : BaseMvpView {
    fun updateImages()
    fun updateTitleName()
}