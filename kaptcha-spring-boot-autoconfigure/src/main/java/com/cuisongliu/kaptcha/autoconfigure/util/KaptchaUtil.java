package com.cuisongliu.kaptcha.autoconfigure.util;
/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 cuisongliu@qq.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import com.google.code.kaptcha.Constants;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * kaptcha 工具类
 *
 * @author cuisongliu [cuisongliu@qq.com]
 * @since 2018-01-02 22:00
 */
public class KaptchaUtil {

    /**
     * @param inputName input 提交的name值
     * @param suffix 传递验证码controller的suffix参数
     * @return 是否验证通过
     */
    public static Boolean validationKaptcha(final String inputName,final String suffix,final Boolean enable){
        if (enable){
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String kaptchaValue = request.getParameter(inputName).trim();
            String sessionValue =(String)request.getSession().getAttribute(kaptchaKeyGenerator(suffix));
            return !(StringUtils.isEmpty(kaptchaValue) || !kaptchaValue.equalsIgnoreCase(sessionValue));
        }else {
            return true;
        }
    }

    /**
     * @param inputName input 提交的name值
     * @return 是否验证通过
     */
    public static Boolean validationKaptcha(final String inputName,final Boolean enable){
        return validationKaptcha(inputName,"",enable);
    }

    /**
     * @param kaptchaParamSuffix 验证码传递参数的后缀 验证码参数后缀
     * @return 返回生成的验证码 session key
     */
    public static String kaptchaKeyGenerator(final String kaptchaParamSuffix){
        if (StringUtils.isEmpty(kaptchaParamSuffix)){
            return Constants.KAPTCHA_SESSION_KEY;
        }else {
            return Constants.KAPTCHA_SESSION_KEY + "_"+ Base64Utils.encodeToUrlSafeString(kaptchaParamSuffix.getBytes());
        }
    }
}
