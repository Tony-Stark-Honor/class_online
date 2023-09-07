package com.jtc.ykt.vod.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jtc.ykt.model.vod.VideoVisitor;
import com.jtc.ykt.vo.vod.VideoVisitorCountVo;

import java.util.List;

/**
 * @Author: 小天
 * @Date: 2023/8/30 - 08 - 30 - 14:19
 * @Decsription: com.jtc.ykt.vod.mapper
 * @version: 1.0
 */
public interface VideoVisitorMapper extends BaseMapper<VideoVisitor> {

    public List<VideoVisitorCountVo> findCount(Long courseId, String startDate, String endDate);
}
