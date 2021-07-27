package com.colutti.client.configuration

import io.rsocket.RSocket
import io.rsocket.RSocketFactory
import io.rsocket.frame.decoder.PayloadDecoder
import io.rsocket.transport.netty.client.TcpClientTransport
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.rsocket.MetadataExtractor
import org.springframework.messaging.rsocket.RSocketRequester
import org.springframework.messaging.rsocket.RSocketStrategies
import org.springframework.util.MimeTypeUtils

@Configuration
class RSocketClientConfig {

    @Bean
    fun rSocketRequester(rSocketStrategies: RSocketStrategies): RSocketRequester? {
        return RSocketRequester.builder()
                .rsocketStrategies(rSocketStrategies)
                .connectTcp("localhost", 7000)
                .block()
    }


}