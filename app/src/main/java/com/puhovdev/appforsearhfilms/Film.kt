package com.puhovdev.appforsearhfilms

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film(
    val id: Int,
    val title: String,
    val description: String,
    val year: Int,
    val poster: Int,
    var isInFavorites: Boolean = false
) : Parcelable






