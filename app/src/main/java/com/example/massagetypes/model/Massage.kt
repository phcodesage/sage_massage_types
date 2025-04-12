package com.example.massagetypes.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Massage(
    val name: String,
    val description: String,
    val imageResource: Int,
    val origin: String,
    val benefits: List<String>,
    val techniques: List<String>,
    val recommendedDuration: String,
    val pressure: String,
    val history: String
) : Parcelable