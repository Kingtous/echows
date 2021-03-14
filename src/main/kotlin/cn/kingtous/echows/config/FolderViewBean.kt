package cn.kingtous.echows.config

import org.apache.catalina.Context
import org.apache.catalina.Wrapper
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.server.WebServerFactoryCustomizer
import org.springframework.stereotype.Component

@Component
class FolderViewBean : WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
    override fun customize(factory: TomcatServletWebServerFactory?) {
//        factory?.addContextCustomizers(object : TomcatContextCustomizer{
//            override fun customize(context: Context?) {
//                context?.let {
//                    it.docBase = "/Users/bytedance/tmp"
//                    val defServlet : Wrapper = (it.findChild("default")) as Wrapper
//                    defServlet.addInitParameter("listings","true")
//                    defServlet.addInitParameter("readOnly","false")
//                    defServlet.addMapping("/imgs/*")
//                }
//            }
//
//        })
    }

}