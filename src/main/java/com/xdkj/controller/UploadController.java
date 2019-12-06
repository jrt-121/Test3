package com.xdkj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author guo
 * @create 2019-12-04 10:16
 */

@Controller
public class UploadController {


    //单个文件
    @RequestMapping("upload")
    @ResponseBody
    public String upload( MultipartFile uplodFile)throws IOException {//变量名要与index.html中的input里的name一致，不一致可通过@RequestParam指定
        String fileName = uplodFile.getOriginalFilename();//获取真实文件名称

        String uploadPath="D:\\upload\\";

        uplodFile.transferTo(new File(uploadPath+fileName));

        return "success";

    }

//多个文件，保证名字一样
    @RequestMapping("upload2")
    @ResponseBody
    public String upload2(MultipartFile [] uplodFile)throws IOException {//变量名要与index.html中的input里的name一致，不一致可通过@RequestParam指定

        for (MultipartFile multipartFile : uplodFile) {

            String fileName = multipartFile.getOriginalFilename();//获取真实文件名称

            String uploadPath="D:\\upload\\";

            multipartFile.transferTo(new File(uploadPath+fileName));
            
        }


        return "success";

    }

    @RequestMapping("ajaxupload")
    @ResponseBody
    public String upload3( MultipartFile uplodFile)throws IOException {//变量名要与index.html中的input里的name一致，不一致可通过@RequestParam指定
        String fileName = uplodFile.getOriginalFilename();//获取真实文件名称

        String uploadPath="D:\\upload\\";

        uplodFile.transferTo(new File(uploadPath+fileName));

        return "success";

    }



}
