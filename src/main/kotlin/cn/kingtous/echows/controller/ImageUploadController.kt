package cn.kingtous.echows.controller

import org.springframework.stereotype.Controller

import java.io.IOException

import javax.servlet.http.HttpServletRequest

import org.springframework.web.multipart.MultipartFile

import org.springframework.web.bind.annotation.RequestParam

import org.springframework.web.bind.annotation.ResponseBody

import org.springframework.web.bind.annotation.RequestMethod

import org.springframework.web.bind.annotation.RequestMapping
import org.thymeleaf.util.TextUtils
import java.io.File
import java.util.*


@Controller
class ImageUploadController {

    val loc = "/home/jintao.kingtous/"

    // TODO 接入七牛云
    @RequestMapping(value = ["/img/upload"], method = [RequestMethod.POST])
    @ResponseBody
    fun uploadImg(
        @RequestParam(value = "file", required = true) multipartFile: MultipartFile,
        request: HttpServletRequest
    ): Map<String, Any>? {
        // TODO 鉴权
        val filename  = multipartFile.originalFilename
//        val strPath = "/home/jintao.kingtous/temp-file"
        val strPath = "/Users/bytedance/temp"
        val ts = System.currentTimeMillis()
        val fPath = "${strPath}/${ts}_${filename}"
        val destFile = File(fPath)
        if (destFile.exists()){
            destFile.delete()
        }
        destFile.createNewFile()
        multipartFile.transferTo(destFile);
        return if (!destFile.exists()){
            // 返回的数据结果
            val result: MutableMap<String, Any> = HashMap()
            result["success"] = -1
            result["message"] = "图片上传失败"
            result
        } else {
            // 返回的数据结果
            val result: MutableMap<String, Any> = HashMap()
            result["success"] = 1
            result["message"] = "图片上传成功"
            result["url"] = "/imgs/${ts}_${filename}"
            result
        }
    }

}