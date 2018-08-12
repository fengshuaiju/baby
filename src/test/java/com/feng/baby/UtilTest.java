package com.feng.baby;

import com.feng.baby.support.utils.UploadFile;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.GeneratePresignedUrlRequest;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.UUID;

public class UtilTest {

    @Test
    public void uploadFile(){
        //初始化客户端 cosclient
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials("AKIDNaYIn4btRmtlPoHuc5KK6dz6xYt2NYv2", "2pNgngLn13rRoyud8QVM0RffT1IK5apo");
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region("ap-beijing"));
        // 3 生成cos客户端
        COSClient cosClient = new COSClient(cred, clientConfig);
        // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
        String bucketName = "fengshuaiju-1252541513";


        //上传文件
        // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20M以下的文件使用该接口
        // 大文件上传请参照 API 文档高级 API 上传
        File localFile = new File("/Users/jyd/Documents/qiche.jpg");
        // 指定要上传到 COS 上对象键
        // 对象键（Key）是对象在存储桶中的唯一标识。例如，在对象的访问域名 `bucket1-1250000000.cos.ap-guangzhou.myqcloud.com/doc1/pic1.jpg` 中，对象键为 doc1/pic1.jpg, 详情参考 [对象键](https://cloud.tencent.com/document/product/436/13324)
        String key = UUID.randomUUID().toString() + "-qiche.jpg";
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

//        GeneratePresignedUrlRequest req = new GeneratePresignedUrlRequest(bucketName, key);
//        URL url = cosClient.generatePresignedUrl(req);

        // 关闭客户端(关闭后台线程)
        cosClient.shutdown();
    }


    @Test
    public void pathTest(){
        System.err.println(UploadFile.class.getResource("/").getPath());
    }
}
