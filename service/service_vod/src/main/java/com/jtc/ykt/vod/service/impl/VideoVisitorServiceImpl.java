package com.jtc.ykt.vod.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jtc.ykt.model.vod.VideoVisitor;
import com.jtc.ykt.vo.vod.VideoVisitorCountVo;
import com.jtc.ykt.vod.mapper.VideoVisitorMapper;
import com.jtc.ykt.vod.service.VideoVisitorService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: 小天
 * @Date: 2023/8/30 - 08 - 30 - 14:14
 * @Decsription: com.jtc.ykt.vod.service.impl
 * @version: 1.0
 */
@Service
public class VideoVisitorServiceImpl extends ServiceImpl<VideoVisitorMapper, VideoVisitor> implements VideoVisitorService {
    @Override
    public Map<String, Object> findCount(Long courseId, String startDate, String endDate) {
        List<VideoVisitorCountVo> videoVisitorCountVoList = baseMapper.findCount(courseId,startDate,endDate);
        Map<String,Object> map = new HashMap<>();
        List<Date> dateList = videoVisitorCountVoList.stream().map(VideoVisitorCountVo::getJoinTime).collect(Collectors.toList());
        List<Integer> countList = videoVisitorCountVoList.stream().map(VideoVisitorCountVo::getUserCount).collect(Collectors.toList());
        map.put("xData",dateList);
        map.put("yData",countList);
        return map;
    }
}
