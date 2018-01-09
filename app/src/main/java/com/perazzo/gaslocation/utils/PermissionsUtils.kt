package com.perazzo.gaslocation.utils

import android.app.Activity
import android.content.pm.PackageManager
import android.support.v4.content.ContextCompat

class PermissionsUtils {

    companion object {
        fun hasPermission(activity: Activity, permission: String): Boolean {
            return ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED
        }
    }
}