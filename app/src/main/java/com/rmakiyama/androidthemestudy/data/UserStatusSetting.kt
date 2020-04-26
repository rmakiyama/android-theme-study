package com.rmakiyama.androidthemestudy.data

import android.content.Context
import androidx.core.content.edit

interface UserStatusSetting {

    val isProMode: Boolean

    fun toggleProMode()
}

internal class UserStatusSettingImpl(
    context: Context
) : UserStatusSetting {

    private val data = context.getSharedPreferences("user_status", Context.MODE_PRIVATE)

    override val isProMode: Boolean
        get() = data.getBoolean(PREFERENCE_KEY_IS_PRO, false)

    override fun toggleProMode() {
        data.edit {
            putBoolean(PREFERENCE_KEY_IS_PRO, !data.getBoolean(PREFERENCE_KEY_IS_PRO, false))
        }
    }

    companion object {
        const val PREFERENCE_KEY_IS_PRO = "is_pro"
    }
}
