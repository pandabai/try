package com.qq.regist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class UserInformation {

	public Properties userInfomation;

	//注册一个用户
	public void insert(String userName, String userPassword) {
		
			PropertiesConfigHelper.write(userName, userName, "/userInfo.properties");
			PropertiesConfigHelper.write(userPassword, userPassword, "/userInfo.properties");

	}
	//判断此用户名是否存在
	public boolean isExist(String userName) {
		try {
			userInfomation = new Properties();
			InputStream is;
			is = new FileInputStream("c:/userInfo.properties");
			userInfomation.load(is);
			if (userInfomation.containsKey(userName)) {
				return true;
			}

		} catch (FileNotFoundException e1) {
			System.out.println("文件userInfo.properties没有找到 ");
		} catch (IOException e) {
			System.out.println("写 userInfo.properties 出错");
		}
		return false;
	}

}
