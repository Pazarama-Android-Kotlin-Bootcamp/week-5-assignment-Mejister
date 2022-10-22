package com.merttoptas.retrofittutorial.data.repository

import com.merttoptas.retrofittutorial.data.local.database.entity.PostEntity
import com.merttoptas.retrofittutorial.data.local.database.entity.UsersEnitty
import com.merttoptas.retrofittutorial.data.model.Post
import com.merttoptas.retrofittutorial.data.model.Users
import retrofit2.Call




    interface UsersRepository {
        fun getUsers(): Call<List<Users>>
    }
