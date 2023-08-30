package com.jtc.ykt.vod.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jtc.ykt.model.vod.Course;
import com.jtc.ykt.vo.vod.CoursePublishVo;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author 天赐
 * @since 2023-08-28
 */
public interface CourseMapper extends BaseMapper<Course> {

    CoursePublishVo selectCoursePublishVoById(Long id);
}
