package com.linuxea.mvc.method;

import com.linuxea.mvc.constant.MethodTypeEnum;
import com.linuxea.mvc.exception.MethodTypeException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * post method
 *
 * @author linuxea
 * @date 2017-11-25
 */
public abstract class AbstractPostMethod<T> extends AbstractMethod<T> {
	
	/**
	 * validate method if post
	 *
	 * @param httpServletRequest
	 * @param httpServletResponse
	 */
	@Override
	public final void validateType(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		if (httpServletRequest.getMethod().equalsIgnoreCase(MethodTypeEnum.POST.name()) == false) {
			throw new MethodTypeException("com.linuxea.mvc.method type is not post");
		}
	}

}
