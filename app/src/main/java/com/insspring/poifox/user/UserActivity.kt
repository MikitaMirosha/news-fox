package com.insspring.poifox.user

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import com.arellomobile.mvp.presenter.InjectPresenter
import com.bumptech.glide.Glide
import com.insspring.poifox.R
import com.insspring.poifox.ui.base.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_login.*

class UserActivity : BaseMvpActivity(), UserView {

    @InjectPresenter
    lateinit var initialPresenter: UserPresenter

    override fun getLayoutId(): Int = R.layout.activity_user

    override fun onCreateActivity(savedInstanceState: Bundle?) {}

    override fun updateImages() {
        Glide.with(this)
            .load(R.drawable.ic_fox)
            .placeholder(R.drawable.ic_fox)
            .into(vIvFox)
    }

    override fun updateTitleName() {
        val spannable = SpannableString(getString(R.string.poifox))
        spannable.setSpan(
            ForegroundColorSpan(Color.WHITE),
            0,
            2,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            ForegroundColorSpan(Color.parseColor("#EB874B")),
            3,
            6,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        vTvTitleNameLogin.text = spannable
    }
}