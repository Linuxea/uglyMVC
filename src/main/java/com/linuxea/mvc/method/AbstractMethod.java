package com.linuxea.mvc.method;

import com.alibaba.fastjson.JSON;
import com.linuxea.mvc.annotations.data.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.annotation.Annotation;
import java.nio.charset.Charset;

/**
 * abstract method
 *
 * @author linuxea
 * @date 2017-11-25
 */
public abstract class AbstractMethod<T> {
	
	/**
	 * method type validate
	 *
	 * @param httpServletRequest
	 * @param httpServletResponse
	 */
	public abstract void validateType(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);
	
	/**
	 * subclass service do
	 *
	 * @return
	 */
	public abstract T doIt();
	
	/**
	 * method logic
	 *
	 * @param httpServletRequest
	 * @param httpServletResponse
	 */
	public final void process(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		this.validateType(httpServletRequest, httpServletResponse);
		T t = this.doIt();
		// has not response data
		if (null == t) {
			return;
		}
		// "this" is the abstract method instance
		Annotation[] annotations = this.getClass().getAnnotations();
		boolean skip = true;
		for (int i = 0; i < annotations.length; i++) {
			Annotation annotation = annotations[i];
			if (annotation.annotationType() == Json.class) {
				try {
					String string = JSON.toJSONString(t);
					byte[] bytes = string.getBytes(Charset.defaultCharset());
					httpServletResponse.setContentType("application/json;charset=UTF-8");
					httpServletResponse.setContentLength(bytes.length);
					httpServletResponse.getOutputStream().write(bytes);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (annotation.annotationType() == Text.class) {
				try {
					String string = t.toString();
					byte[] bytes = string.getBytes(Charset.defaultCharset());
					httpServletResponse.setContentType("text/plain;charset=UTF-8");
					httpServletResponse.setContentLength(bytes.length);
					httpServletResponse.getOutputStream().write(bytes);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else if (annotation.annotationType() == Xml.class) {
			
			} else if (annotation.annotationType() == Html.class) {
				try {
					String string = t.toString();
					byte[] bytes = string.getBytes(Charset.defaultCharset());
					httpServletResponse.setContentType("text/html;charset=UTF-8");
					httpServletResponse.setContentLength(bytes.length);
					httpServletResponse.getOutputStream().write(bytes);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (annotation.annotationType() == Img.class) {
				// accept a path point to image file
				File file = new File(t.toString());
				byte[] bytes;
				try {
					FileInputStream fileInputStream = new FileInputStream(file);
					ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
					byte[] tempByte = new byte[1024];
					int flag;
					while (-1 != (flag = fileInputStream.read(tempByte))) {
						byteArrayOutputStream.write(tempByte, 0, flag);
					}
					bytes = byteArrayOutputStream.toByteArray();
					httpServletResponse.setContentType("image/jpeg");
					httpServletResponse.setContentLength(bytes.length);
					httpServletResponse.getOutputStream().write(bytes);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				skip = false;
			}
			
			// has been handled then skip
			// 只会处理数据注解中的一个
			if (skip) {
				break;
			}
		}
	}

}
