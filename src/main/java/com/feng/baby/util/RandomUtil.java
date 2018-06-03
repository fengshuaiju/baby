package com.feng.baby.util;

import java.util.Random;

/**
 * Created by fengshuaiju on 2018-05-15.
 */
public class RandomUtil {

    /**
     * 生成8位随机数字
     * @return
     */
    public static String generate(){
        StringBuilder str = new StringBuilder();//定义变长字符串
        Random random = new Random();
        //随机生成数字，并添加到字符串
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }

}
