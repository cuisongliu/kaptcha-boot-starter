package com.cuisongliu.kaptcha.autoconfigure.properties;
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

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

import static com.cuisongliu.kaptcha.autoconfigure.properties.KaptchaProperties.KAPTCHA_PREFIX;

/**
 * kaptcha 相关的参数
 *
 * @author cuisongliu [cuisongliu@qq.com]
 * @since 2018-01-02 20:47
 */
@ConfigurationProperties(prefix = KAPTCHA_PREFIX)
public class KaptchaProperties {
    public static final String KAPTCHA_PREFIX="spring.kaptcha";

    /**
     * 是否开启验证码
     */
    private Boolean enable=false;

    /**
     * 根据这个参数获取kaptcha需要设置的值,验证码后缀
     */
    private String suffix ="";
    /**
     * 相关的参数
     */
    private Properties properties= new Properties();

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
