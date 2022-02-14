package com.example.jetpackcomposebeginners.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Message(val author: String, val body: String, val resImg: Int) : Parcelable
