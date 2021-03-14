package cn.kingtous.echows.ws

import cn.kingtous.echows.controller.TestEchoWebSocketController
import cn.kingtous.echows.controller.TestParamsWebSocketHandler
import cn.kingtous.echows.intercepters.AuthInteceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry
import org.springframework.web.socket.server.HandshakeInterceptor
import org.springframework.web.socket.server.standard.ServerEndpointExporter
import java.lang.Exception
import javax.servlet.http.HttpUtils

@Configuration
@EnableWebSocket
class WsConfig : WebSocketConfigurer{

    @Bean
    fun serverEndpoointExporter() : ServerEndpointExporter{
        return ServerEndpointExporter()
    }

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {

    }
}