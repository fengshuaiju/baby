package com.feng.util;

import java.net.URLClassLoader;
import java.util.Arrays;

import org.jboss.jandex.Main;

/**
 * 检测项目中依赖了哪些jar包
 * @author Administrator
 *
 */
public class CheckJar {
	public static String checkMyJar(){
		URLClassLoader classLoader = (URLClassLoader)Main.class.getClassLoader();
		return Arrays.toString(classLoader.getURLs());
	}
}
