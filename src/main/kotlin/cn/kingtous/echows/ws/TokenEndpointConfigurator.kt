package cn.kingtous.echows.ws

import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import javax.websocket.server.ServerEndpointConfig

class TokenEndpointConfigurator : ServerEndpointConfig.Configurator() {

    override fun checkOrigin(originHeaderValue: String?): Boolean {
        val requestAttributes = RequestContextHolder.getRequestAttributes()
        requestAttributes ?: return false
        val attributes: ServletRequestAttributes = requestAttributes as ServletRequestAttributes
        val token = attributes.request.getHeader("token") ?: return false
        return token == "bytedance"
    }
}