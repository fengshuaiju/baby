package com.feng.util.qiniu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.feng.base.BaseComponent;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

@Service
public class QiniuSecret extends BaseComponent{

	// 设置好账号的ACCESS_KEY和SECRET_KEY
	private String ACCESS_KEY = "qfOalsdYGGN98dwCWVyaVtT96yVscDgHlrVW84ow";
	private String SECRET_KEY = "EJykZvUo4wSV0qdS-u4pq6Es9FpXZVV1-P39Mlj0";
	// 要上传的空间
	@Value("#{settings['bucket_name']}")
	private String bucketname;

	// 密钥配置
	Auth auth = Auth.create(getACCESS_KEY(), getSECRET_KEY());
	// 创建上传对象
	UploadManager uploadManager = new UploadManager();

	// 简单上传，使用默认策略，只需要设置上传的空间名就可以了
	public String getUpToken() {
		return auth.uploadToken(getBucketname());
	}
	
	
	public String getACCESS_KEY() {
		return ACCESS_KEY;
	}

	public String getSECRET_KEY() {
		return SECRET_KEY;
	}

	public String getBucketname() {
		return bucketname;
	}
}