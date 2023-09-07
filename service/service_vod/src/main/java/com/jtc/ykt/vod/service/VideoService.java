package com.jtc.ykt.vod.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.jtc.ykt.model.vod.Video;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author 天赐
 * @since 2023-08-28
 */
public interface VideoService extends IService<Video> {

    void removeVideoByCourseId(Long id);

    void removeVideoById(Long id);
}
