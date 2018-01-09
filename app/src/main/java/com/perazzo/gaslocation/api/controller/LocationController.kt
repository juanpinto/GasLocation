package com.perazzo.gaslocation.api.controller

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.os.Bundle
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.*
import com.google.android.gms.tasks.OnSuccessListener
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject

class LocationController(private val context: Context) : GoogleApiClient.ConnectionCallbacks, LocationCallback(),
        GoogleApiClient.OnConnectionFailedListener, OnSuccessListener<Location> {

    private lateinit var googleApiClient: GoogleApiClient

    val locationSubject: BehaviorSubject<Location> = BehaviorSubject.create()

    init {
        buildApiClient()
    }


    private fun buildApiClient() {
        googleApiClient = GoogleApiClient.Builder(context)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build()
    }

    fun connect() {
        googleApiClient.connect()
    }

    fun disconnect() {
        googleApiClient.disconnect()
    }

    @SuppressLint("MissingPermission")
    override fun onConnected(p0: Bundle?) {
        LocationServices.getFusedLocationProviderClient(context).lastLocation.addOnSuccessListener(this)
    }

    override fun onSuccess(location: Location?) {
        location.let {
            locationSubject.onNext(location)
        }
    }

    override fun onConnectionSuspended(number: Int) {
        locationSubject.onError(Throwable("Connection suspended"))
    }

    override fun onConnectionFailed(error: ConnectionResult) {
        locationSubject.onError(Throwable(error.errorMessage))
    }
}
