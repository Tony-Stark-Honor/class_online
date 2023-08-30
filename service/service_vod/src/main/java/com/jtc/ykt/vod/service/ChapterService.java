package com.jtc.ykt.vod.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.jtc.ykt.model.vod.Chapter;
import com.jtc.ykt.vo.vod.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author 天赐
 * @since 2023-08-28
 */
public interface ChapterService extends IService<Chapter> {

    List<ChapterVo> getNestedTreeList(Long courseId);

    void removeChapterByCourseId(Long id);
}
