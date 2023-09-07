package com.jtc.ykt.vod.controller;

import com.jtc.ykt.Result;
import com.jtc.ykt.vod.service.VideoVisitorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: 小天
 * @Date: 2023/8/30 - 08 - 30 - 13:45
 * @Decsription: com.jtc.ykt.vod.controller
 * @version: 1.0
 */
@Api(value = "VideoVisitor管理",tags = "VideoVisitor管理")
@RestController
@RequestMapping(value = "/admin/vod/videoVisitor")
public class VideoVisitorController {

    @Autowired
    VideoVisitorService videoVisitorService;

    @ApiOperation("显示统计数据")
    @GetMapping("/findCount/{courseId}/{startDate}/{endDate}")
    public Result showChart(
            @ApiParam("课程ID") @PathVariable("courseId") Long courseId,
            @ApiParam("开始时间") @PathVariable("startDate") String startDate,
            @ApiParam("结束时间") @PathVariable("endDate") String endDate
    ){
        Map<String,Object> map = videoVisitorService.findCount(courseId,startDate,endDate);
        return Result.ok(map);
    }
}
