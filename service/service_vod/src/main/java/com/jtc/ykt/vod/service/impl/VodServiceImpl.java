package com.jtc.ykt.vod.service.impl;

import com.jtc.ykt.utils.ConstantPropertiesUtil;
import com.jtc.ykt.vod.service.VodService;
import com.qcloud.vod.VodUploadClient;
import com.qcloud.vod.model.VodUploadRequest;
import com.qcloud.vod.model.VodUploadResponse;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.vod.v20180717.VodClient;
import com.tencentcloudapi.vod.v20180717.models.DeleteMediaRequest;
import com.tencentcloudapi.vod.v20180717.models.DeleteMediaResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author: 小天
 * @Date: 2023/8/30 - 08 - 30 - 14:45
 * @Decsription: com.jtc.ykt.vod.service.impl
 * @version: 1.0
 */
@Service
public class VodServiceImpl implements VodService {
    @Override
    public String uploadVideo(MultipartFile file) {
//        设置连接信息
        VodUploadClient vodUploadClient = new VodUploadClient(ConstantPropertiesUtil.ACCESS_KEY_ID,ConstantPropertiesUtil.ACCESS_KEY_SECRET);
//        设置上传对象
        VodUploadRequest request = new VodUploadRequest();
//        设置本地上传路径
        String absolutePath = null;

        try {
//        创建上传文件
            File uploadFile = new File(file.getOriginalFilename());
//        获取文件的绝对路径
            absolutePath = uploadFile.getAbsolutePath();
            file.transferTo(new File(absolutePath));
            request.setMediaFilePath(absolutePath);
            VodUploadResponse response = vodUploadClient.upload("ap-beijing",request);
            String fileId = response.getFileId();
            return fileId;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            File temp = new File(absolutePath);
            temp.delete();
        }
        return null;
    }

    @Override
    public void removeVideo(String videoSourceId) {

        try {
            Credential credential = new Credential(ConstantPropertiesUtil.ACCESS_KEY_ID,ConstantPropertiesUtil.ACCESS_KEY_SECRET);

            VodClient client = new VodClient(credential,"ap-beijing");

            DeleteMediaRequest request = new DeleteMediaRequest();

            request.setFileId(videoSourceId);

            DeleteMediaResponse response = client.DeleteMedia(request);

            System.out.println(DeleteMediaResponse.toJsonString(response));
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        } finally {
        }
    }
}
