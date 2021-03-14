package cn.kingtous.echows.controller

import cn.kingtous.echows.ws.TokenEndpointConfigurator
import org.apache.tomcat.websocket.WsSession
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler
import org.springframework.web.socket.sockjs.transport.session.WebSocketServerSockJsSession
import org.springframework.web.util.UriComponentsBuilder
import java.nio.ByteBuffer
import java.util.concurrent.ConcurrentHashMap
import javax.websocket.*
import javax.websocket.server.PathParam
import javax.websocket.server.ServerEndpoint
import kotlin.math.sign

/**
 * 连接时进行params回调
 */
@ServerEndpoint("/ws/test-params",configurator = TokenEndpointConfigurator::class)
@Controller
class TestParamsWebSocketHandler{

    @OnMessage
    fun onMessage(message: String, session: WsSession) {
        print(session.javaClass.toString())
        when (message){
            "params" -> {
                session.basicRemote.sendText(UriComponentsBuilder.fromUri(session.requestURI!!).build().queryParams.toString())
            }
            else -> {
                session.basicRemote.sendText(message)
            }
        }
    }
}