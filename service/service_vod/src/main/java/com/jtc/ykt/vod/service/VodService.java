package com.jtc.ykt.vod.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: 小天
 * @Date: 2023/8/30 - 08 - 30 - 14:45
 * @Decsription: com.jtc.ykt.vod.service
 * @version: 1.0
 */
public interface VodService {
    String uploadVideo(MultipartFile file);

    void removeVideo(String videoSourceId);
}
