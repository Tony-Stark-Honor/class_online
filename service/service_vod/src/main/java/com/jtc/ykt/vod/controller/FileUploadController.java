package com.jtc.ykt.vod.controller;

import com.jtc.ykt.Result;
import com.jtc.ykt.vod.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: 小天
 * @Date: 2023/8/25 - 08 - 25 - 17:09
 * @Decsription: com.jtc.ykt.vod.controller
 * @version: 1.0
 */
@Api(tags = "文件上传接口")
@RestController
@RequestMapping("/admin/vod/file")
public class FileUploadController {
    @Autowired
    private FileService fileService;

    @ApiOperation(value = "文件上传")
    @PostMapping("upload")
    public Result upload(@ApiParam(name = "file",value = "文件",required = true)
                         @RequestParam("file")MultipartFile multipartFile){
       String uploadUrl = fileService.upload(multipartFile);
       return Result.ok(uploadUrl).message("文件上传成功");
    }


}
