package com.jtc.ykt.vod.service.impl;

import com.alibaba.fastjson.JSON;
import com.jtc.ykt.utils.ConstantPropertiesUtil;
import com.jtc.ykt.vod.service.FileService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;


/**
 * @Author: 小天
 * @Date: 2023/8/25 - 08 - 25 - 14:42
 * @Decsription: com.jtc.ykt.vod.service.impl
 * @version: 1.0
 */
@Service
public class FileServiceImpl implements FileService {
    @Override
    public String upload(MultipartFile multipartFile) {
        String endpoint = ConstantPropertiesUtil.END_POINT;
        String buckerName = ConstantPropertiesUtil.BUCKET_NAME;
        String secretId = ConstantPropertiesUtil.ACCESS_KEY_ID;
        String secretKey = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
//        初始化用户信息
        COSCredentials credentials = new BasicCOSCredentials(secretId,secretKey);

//        设置bucket地域
        Region region = new Region(ConstantPropertiesUtil.END_POINT);
        ClientConfig clientConfig = new ClientConfig(region);

//        根据配置信息生成COS客户端
        clientConfig.setHttpProtocol(HttpProtocol.https);
        COSClient cosClient = new COSClient(credentials,clientConfig);

        try {
//            获取IO流
            InputStream inputStream = multipartFile.getInputStream();
//            指定要上传的存储桶以及文件名
//            文件名
            String key = UUID.randomUUID().toString().replaceAll("-","")+multipartFile.getOriginalFilename();
//            格式化时间
            String dateUrl = new DateTime().toString("yyyy-MM-dd");
            key = dateUrl+"/"+key;

            ObjectMetadata objectMetadata = new ObjectMetadata();
            PutObjectRequest putObjectRequest = new PutObjectRequest(buckerName,key,inputStream,objectMetadata);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            System.out.println(JSON.toJSONString(putObjectResult));

            String url = "https://"+buckerName+"."+"cos"+"."+endpoint+".myqcloud.com"+"/"+key;
            return url;

        } catch (Exception clientException) {
            clientException.printStackTrace();
            return null;
        }

    }
}
