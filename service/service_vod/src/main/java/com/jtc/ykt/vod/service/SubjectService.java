package com.jtc.ykt.vod.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.jtc.ykt.model.vod.Subject;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author 天赐
 * @since 2023-08-25
 */
public interface SubjectService extends IService<Subject> {

    List<Subject> selectList(Long id);

    /**
     * 导出
     * @param response
     */
    void exportData(HttpServletResponse response);

    void importDictData(MultipartFile file);
}
