package io.github.fragments

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class XModel(
    val id: String
): Parcelable
