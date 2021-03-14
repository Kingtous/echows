package cn.kingtous.echows.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.nio.ByteBuffer
import java.util.concurrent.ConcurrentHashMap
import javax.websocket.*
import javax.websocket.server.PathParam
import javax.websocket.server.ServerEndpoint

@Controller
class ProgressChartWebSocketController {

    @GetMapping(value = ["/chart"])
    fun index() : String{
        return "chart"
    }
}