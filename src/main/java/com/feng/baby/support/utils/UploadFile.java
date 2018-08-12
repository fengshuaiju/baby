package com.feng.baby.support.utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Component
public class UploadFile {

    @Value("${appId:1252541513}")
    private static final String appId = "1252541513";

    @Value("${secretId:AKIDNaYIn4btRmtlPoHuc5KK6dz6xYt2NYv2}")
    private static final String secretId = "AKIDNaYIn4btRmtlPoHuc5KK6dz6xYt2NYv2";

    @Value("${secretKey:2pNgngLn13rRoyud8QVM0RffT1IK5apo}")
    private static final String secretKey = "2pNgngLn13rRoyud8QVM0RffT1IK5apo";

    private static final String region = "ap-beijing";
    private static final String bucketName = "fengshuaiju-1252541513";

    private static COSCredentials cred;
    private static ClientConfig clientConfig;
    private static COSClient cosClient;

    public UploadFile(){
        // 1 初始化用户身份信息(secretId, secretKey)
        cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        clientConfig = new ClientConfig(new Region(region));
        // 3 生成cos客户端
        cosClient = new COSClient(cred, clientConfig);
        // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
        String bucketName = "fengshuaiju-1252541513";
    }


    /**
     * 上传文件
     * 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20M以下的文件使用该接口
     * 大文件上传请参照 API 文档高级 API 上传
     * @param file
     */
    public static String uploadFile(File file){
        String key = UUID.randomUUID().toString() + file.getName();
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file);
        cosClient.putObject(putObjectRequest);
        return key;
    }

    public static File transToFile(MultipartFile file){
        String fileName = file.getOriginalFilename();
        String path = UploadFile.class.getResource("/").getPath();
        File dest = new File(path + "/" + fileName);

        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dest;
    }

}
