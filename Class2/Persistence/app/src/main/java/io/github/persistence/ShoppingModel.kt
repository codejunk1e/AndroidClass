package io.github.persistence

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class ShoppingModel(
    val category: String,
    val description: String,

    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0
)