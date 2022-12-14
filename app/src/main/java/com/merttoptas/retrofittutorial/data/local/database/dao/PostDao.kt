package com.merttoptas.retrofittutorial.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.merttoptas.retrofittutorial.data.local.database.base.BaseDao
import com.merttoptas.retrofittutorial.data.local.database.entity.PostEntity
import com.merttoptas.retrofittutorial.data.local.database.entity.UsersEnitty
import com.merttoptas.retrofittutorial.utils.Constants
import java.sql.RowId

/**
 * Created by merttoptas on 16.10.2022.
 */

@Dao
interface PostDao : BaseDao<PostEntity> {
    @Query("SELECT * FROM ${Constants.TABLE_POST_NAME}")
    fun getAllPosts(): List<PostEntity>

    @Query("DELETE FROM ${Constants.TABLE_POST_NAME}")
    fun deleteAll()

    @Query("SELECT * FROM ${Constants.TABLE_POST_NAME} WHERE postId = :postId")
    fun getPostById(postId: String): PostEntity?

}
@Dao
interface UsersDao : BaseDao<UsersEnitty> {
    @Query("SELECT * FROM ${Constants.TABLE_POST_NAME}")
    fun getAllUsers(): List<UsersEnitty>

    @Query("DELETE FROM ${Constants.TABLE_POST_NAME}")
    fun deleteAllUsers()

    @Query("SELECT * FROM ${Constants.TABLE_POST_NAME} WHERE postId = :usersId")
    fun getUsersById(usersId: String): UsersEnitty?


    abstract fun getPostById(toString: String): UsersEnitty?
}