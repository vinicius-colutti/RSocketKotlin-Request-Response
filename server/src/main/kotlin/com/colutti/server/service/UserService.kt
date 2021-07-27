package com.colutti.server.service

import com.colutti.server.model.User

interface UserService {

    fun getUserById(id: Long): User

}