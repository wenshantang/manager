package com.manager.controller.umsg;

import java.util.List;

import cn.aresoft.cms.common.cache.CmsPropertiesCache;
import cn.aresoft.common.model.RetMsg;
import cn.aresoft.manager.controller.CommonController;
import cn.aresoft.manager.plugin.MyBeetlView;

import com.manager.model.Umsg;
import com.manager.service.UmsgService;
import com.puff.framework.annotation.Controller;
import com.puff.framework.annotation.Inject;
import com.puff.jdbc.core.PageRecord;
import com.puff.web.mvc.PuffContext;
import com.puff.web.view.View;
import com.puff.web.view.ViewFactory;

@Controller(value = "/admin/umsg")
public class UmsgController extends CommonController {
	@Inject
	private UmsgService umsgService;
	@Inject
	private CmsPropertiesCache cmsPropertiesCache;

	public View index() {
		MyBeetlView view = new MyBeetlView("/umsg/umsg_list.html");
		return view;
	}

	public View json() {
		Umsg umsg = PuffContext.getModel(Umsg.class);
		umsg.setType("2");//'1:活动  2:产品',
		PageRecord<Umsg> data = umsgService.paging(umsg, getCommonParam());
		return ViewFactory.json(data);
	}
	
	public View indexAct() {
		MyBeetlView view = new MyBeetlView("/umsg/umsg_list2.html");
		return view;
	}

	public View jsonAct() {
		Umsg umsg = PuffContext.getModel(Umsg.class);
		umsg.setType("1");//'1:活动  2:产品',
		PageRecord<Umsg> data = umsgService.paging(umsg, getCommonParam());
		return ViewFactory.json(data);
	}
	
	public View delete() {
		List<String> ids = PuffContext.getParameterList("ids", ",");
		for (String id : ids) {
			umsgService.delete(id);
		}
		return ViewFactory.json(RetMsg.success("删除成功！"));
	}
}
