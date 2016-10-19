package com.feng.util.qiniu;

import java.io.File;
import java.io.IOException;

public interface UploadService {

	/**
	 * 
	 * @param file 要上传的文件
	 * @param key  文件名
	 * @throws IOException
	 */
	UploadResultModel uploadInNormal(File file);

}