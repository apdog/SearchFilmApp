package com.puhovdev.appforsearhfilms

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film(
    val title: String,
    val description: String,
    val year: Int,
    val poster: Int
) : Parcelable






