package com.jtc.ykt.client.course;

import com.jtc.ykt.model.vod.Course;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author: 小天
 * @Date: 2023/9/4 - 09 - 04 - 18:50
 * @Decsription: com.jtc.ykt.client.course
 * @version: 1.0
 */
@FeignClient("service-vod")
public interface CourseFeignClient {
    @ApiOperation("根据关键字查询课程")
    @GetMapping("/api/vod/course/inner/findByKeyword/{keyword}")
    List<Course> findByKeyword(@PathVariable String keyword);

}
