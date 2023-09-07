package com.jtc.ykt.vod.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jtc.ykt.model.vod.VideoVisitor;

import java.util.Map;

/**
 * @Author: 小天
 * @Date: 2023/8/30 - 08 - 30 - 14:14
 * @Decsription: com.jtc.ykt.vod.service
 * @version: 1.0
 */
public interface VideoVisitorService {

    Map<String, Object> findCount(Long courseId, String startDate, String endDate);
}
