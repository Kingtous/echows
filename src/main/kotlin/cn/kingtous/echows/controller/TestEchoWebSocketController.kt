package cn.kingtous.echows.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import java.nio.ByteBuffer
import java.util.concurrent.ConcurrentHashMap
import javax.websocket.*
import javax.websocket.server.PathParam
import javax.websocket.server.ServerEndpoint

@ServerEndpoint(value = "/ws/test-echo")
@Controller
class TestEchoWebSocketController {

    val sessionPool: ConcurrentHashMap<Any, Session> = ConcurrentHashMap()

    @OnOpen
    fun onOpen(session: Session) {
        sessionPool.put(session.id, session)
    }

    @OnMessage
    fun onMessage(msg: String, session: Session) {
        if (msg.startsWith("uclose")){
            // 模拟客户端发送了异常请求
            session.close()
            return
        }
        // TODO 数据正常
        session.basicRemote.sendText(msg)
    }

    @OnMessage
    fun onMessage(msg: ByteBuffer,session: Session){
        session.basicRemote.sendBinary(msg)
    }


    @OnClose
    fun onClose(session: Session) {
        sessionPool.remove(session.id)
    }

    @OnError
    fun onError(session: Session,error:Throwable){
        error.printStackTrace()
    }


}