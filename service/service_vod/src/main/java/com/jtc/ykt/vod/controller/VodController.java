package com.jtc.ykt.vod.controller;

import com.jtc.ykt.Result;
import com.jtc.ykt.vod.service.VodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: 小天
 * @Date: 2023/8/30 - 08 - 30 - 14:45
 * @Decsription: com.jtc.ykt.vod.controller
 * @version: 1.0
 */
@Api(tags = "云点播")
@RestController
@RequestMapping("/admin/vod")
public class VodController {
    @Autowired
    private VodService vodService;

//    上传视频
    @PostMapping("/upload")
    public Result uploadVideo(
            @ApiParam(name="file",value = "文件",required=true)
            @RequestParam("file")MultipartFile file)
    {
        String videoId = vodService.uploadVideo(file);
        return Result.ok(videoId);
    }
//    删除图片
    @DeleteMapping("/remove/{videoSourceId}")
    public Result removeVideo(@PathVariable String videoSourceId){
        vodService.removeVideo(videoSourceId);
        return Result.ok();
    }
}
