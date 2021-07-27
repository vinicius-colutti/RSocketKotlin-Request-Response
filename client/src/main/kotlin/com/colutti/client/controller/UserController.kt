package com.colutti.client.controller

import com.colutti.client.model.User
import org.springframework.messaging.rsocket.RSocketRequester
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping(value=["/user"])
class UserController(rSocketRequester: RSocketRequester) {

    private var rSocketRequester: RSocketRequester? = null

    init {
        this.rSocketRequester = rSocketRequester
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable("id") id: Long): Publisher<User>{
        return rSocketRequester?.route("userController")
                ?.data(id)
                ?.retrieveMono(User::class.java)!!
    }

}
