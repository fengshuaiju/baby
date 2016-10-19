package com.feng.util.qiniu;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.feng.util.exception.ExceptionCode;
import com.feng.util.exception.ValidateUtils;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;

@Service
public class UploadServiceImpl extends QiniuSecret implements UploadService {

	@Override
	public UploadResultModel uploadInNormal(File file) {
		UploadResultModel uploadResult = null;
		String key = UUID.randomUUID().toString().replace("-", "");
		try {
			// 调用put方法上传
			Response res = uploadManager.put(file, key, super.getUpToken());
			// 打印返回的信息
			loger.debug("upload fails success : " + res.bodyString());
			uploadResult = JSON.parseObject(res.bodyString(), UploadResultModel.class);
		} catch (QiniuException e) {
			Response r = e.response;
			loger.debug(r.toString());
			ValidateUtils.isTrue(false, ExceptionCode.UPLOAD_FAIL);
		}
		return uploadResult;
	}
}