package com.manager.service;

import cn.aresoft.common.model.CommonParam;
import cn.aresoft.common.service.BaseService;

import com.manager.model.UserBasic;
import com.puff.jdbc.core.PageRecord;

public interface UserBasicService extends BaseService<UserBasic> {
	
	public UserBasic queryBeanWithGenId(String id);
	
	public int updateStatus(String id, String status);
	
	public UserBasic queryByMobile(String mobile);
	
	public int submitStatus(String id);
	
	public PageRecord<UserBasic> paging(UserBasic ub, CommonParam param,String userId) ;
	/**
	 * 检查操作员唯一性
	 * @param cardType
	 * @param cardCode
	 * @return
	 */
	public long checkUnique(String cardType,String cardCode,String id);
	
}
