package cn.kingtous.echows.controller

import org.springframework.core.io.ClassPathResource
import org.springframework.web.bind.annotation.*
import java.io.BufferedReader
import java.io.File

import java.io.InputStreamReader

import java.io.FileInputStream
import kotlin.math.max
import kotlin.math.min


/**
 * 输入特定的参数，直接返回一段内容
 */
@RestController
class MockDataController {

    private final val dataContent : String by lazy {
        readDataFromResouce()
    }

    init {
        println("读取文件长度：${dataContent.length}")
    }

    fun readDataFromResouce() : String{
        var data: String = ""
        try {
            val file = ClassPathResource("testData.json")
            val fis = file.inputStream
            data = String(fis.readBytes())
            fis.close()
        } catch (e : Exception){
            e.printStackTrace()
        }
        return data
    }

    @ResponseBody
    @RequestMapping(value = ["/mock/message/get"],method = [RequestMethod.GET])
    fun getData(@RequestParam(value = "size",required = true) size : Int): String{
        val querySize = min(dataContent.length,max(1,size))
        return dataContent.substring(0,querySize)
    }

    @ResponseBody
    @RequestMapping(value = ["/mock/message/post"],method = [RequestMethod.POST])
    fun getPostData(): String{
        val querySize = min(dataContent.length,max(1,10))
        return dataContent.substring(0,querySize)
    }
}