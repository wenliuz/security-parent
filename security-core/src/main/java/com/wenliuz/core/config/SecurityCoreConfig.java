package com.wenliuz.core.config;

import com.wenliuz.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Project Name:security-parent <br/>
 * Package Name:com.wenliuz.core.config <br/>
 * Date:2018/10/26 14:36 <br/>
 * <b>Description:</b> 让配置属性生效<br/>
 *
 * @author <a href="mailto:zhengwl@eastcom-sw.com">zhengwl</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2018 =======================================================
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
