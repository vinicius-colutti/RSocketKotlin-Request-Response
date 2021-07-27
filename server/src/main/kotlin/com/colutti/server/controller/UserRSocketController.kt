package com.colutti.server.controller

import com.colutti.server.model.User
import com.colutti.server.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller
import reactor.core.publisher.Mono

@Controller
class UserRSocketController {

    @Autowired
    lateinit var service: UserService

    @MessageMapping("userController")
    fun getUserById(id: Long): Mono<User> {
        println("user requested...")
        return Mono.just(service.getUserById(id))
    }

}