package com.insspring.poifox.ui.user

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.insspring.poifox.R
import com.insspring.poifox.ui.base.BaseMvpActivity

class UserActivity : BaseMvpActivity(), UserView {

    @InjectPresenter
    lateinit var initialPresenter: UserPresenter

    override fun getLayoutId(): Int = R.layout.activity_user

    override fun onCreateActivity(savedInstanceState: Bundle?) {}

}