package com.merttoptas.retrofittutorial.data.repository



import com.merttoptas.retrofittutorial.data.model.Users

import com.merttoptas.retrofittutorial.data.remote.api.UserApiService
import retrofit2.Call

class UsersRepositoryImpl

     constructor(
        private val apiService: UserApiService,
    ) : UsersRepository {

        override fun getUsers(): Call<List<Users>> {
            return apiService.getUsers()
        }
/*
        override fun getUsersById(id: Int): PostEntity? {
            return postsDatabase.usersDao().getUsersById(id.toString())
        }

        override fun insertFavoriteUsers(post: PostEntity) {
            return postsDatabase.usersDao().insert(post)
        }

        override fun deleteFavoriteUsers(post: PostEntity) {
            return postsDatabase.usersDao().delete(post)
        }*/
    }
