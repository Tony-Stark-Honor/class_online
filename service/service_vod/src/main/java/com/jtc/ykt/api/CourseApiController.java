package com.jtc.ykt.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jtc.ykt.model.vod.Course;
import com.jtc.ykt.vod.service.CourseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 小天
 * @Date: 2023/9/4 - 09 - 04 - 18:47
 * @Decsription: com.jtc.ykt.wechat.api
 * @version: 1.0
 */
@RestController
@RequestMapping("/api/vod/course")
public class CourseApiController {
    @Autowired
    private CourseService courseService;
    @ApiOperation("根据关键字查询课程")
    @GetMapping("inner/findByKeyword/{keyword}")
    public List<Course> findByKeyword(
            @ApiParam(value = "关键字",required = true)
            @PathVariable String keyword){
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title",keyword);
        List<Course> list = courseService.list(queryWrapper);
        return list;
    }
}
