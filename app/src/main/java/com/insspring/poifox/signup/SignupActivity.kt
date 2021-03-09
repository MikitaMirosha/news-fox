package com.insspring.poifox.signup

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_signup.*


    @InjectPresenter
    lateinit var signupPresenter: SignupPresenter

    override fun getLayoutId(): Int = R.layout.activity_signup

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        initListeners()
    }

        }

    }

    }

    override fun showInvalidUsername() {
        vEtUsernameLogin?.error = "enter username"
        vEtUsernameLogin?.requestFocus()
    }


    override fun showEditTextInvalidConfirmationHint() {
        vEtConfirmPassword?.error = "invalid confirmation"
        vEtConfirmPassword?.requestFocus()
    }

}