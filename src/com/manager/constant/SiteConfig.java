package com.manager.constant;

import com.puff.ioc.BeanFactory;

import cn.aresoft.cms.common.cache.CmsSiteConfigCache;
import cn.aresoft.cms.common.model.config.CmsSiteConfig;

public class SiteConfig {
	
	public static CmsSiteConfig getCmsSiteConfig() {
		CmsSiteConfigCache cmsSiteConfigCache = BeanFactory.getBean("cmsSiteConfigCache");
		return cmsSiteConfigCache.get("888888888");
	}
}
