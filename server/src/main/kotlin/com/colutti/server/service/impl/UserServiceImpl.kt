package com.colutti.server.service.impl

import com.colutti.server.model.User
import com.colutti.server.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl: UserService {

    override fun getUserById(id: Long): User {
        return User(id, "Vinicius", "vinicius@email.com")
    }

}