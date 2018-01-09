package com.perazzo.gaslocation.ui.activity

import android.Manifest
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.databinding.DataBindingUtil
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import com.perazzo.gaslocation.R
import com.perazzo.gaslocation.databinding.ActivitySplashBinding
import com.perazzo.gaslocation.utils.PermissionsUtils

class SplashActivity: AppCompatActivity() {

    private lateinit var activityBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        requestPermission()

    }

    private fun requestPermission() {
        if (!hasLocationEnabled()) {
            requestPermissionDialog()
        } else {
            startMainActivity()
        }
    }

    private fun hasLocationEnabled(): Boolean {
        return PermissionsUtils.hasPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
    }


    private fun requestPermissionDialog() {
        if (!PermissionsUtils.hasPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1001)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == 1001 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startMainActivity()
        } else {
            permissionRejectedDialog()
        }
    }


    private fun permissionRejectedDialog() {
        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
        dialogBuilder.setMessage(R.string.location_permission_dialog)
        dialogBuilder.setCancelable(false)
        dialogBuilder.setPositiveButton(R.string.ok, { _: DialogInterface, _: Int -> startActivityForResult(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS), 1002) })
        dialogBuilder.create().show()
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}