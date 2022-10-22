package com.merttoptas.retrofittutorial.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.merttoptas.retrofittutorial.utils.Constants

@Entity(tableName = Constants.TABLE_POST_NAME)
data class UsersEnitty(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long? = null,
    @ColumnInfo(name = "postId") val postId: String?,
    @ColumnInfo(name = "postTitle") val postTitle: String?,
    @ColumnInfo(name = "postBody") val postBody: String?,
)