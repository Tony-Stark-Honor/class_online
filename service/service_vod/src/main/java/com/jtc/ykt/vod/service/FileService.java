package com.jtc.ykt.vod.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: 小天
 * @Date: 2023/8/25 - 08 - 25 - 14:40
 * @Decsription: com.jtc.ykt.vod.service
 * @version: 1.0
 */
public interface FileService {
    String upload(MultipartFile multipartFile);
}
