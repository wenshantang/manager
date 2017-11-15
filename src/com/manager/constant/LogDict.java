package com.manager.constant;

public class LogDict {
	/**
	 * 日志级别
	 * @author Galen
	 */
	public static interface LEVEL {
		/**消息*/
		public static String INFO = "0";
		/**错误*/
		public static String ERROR = "1";
		/**警告*/
		public static String WARN = "2";
		/**调试*/
		public static String DEBUG = "3";
	}
	/**
	 * 日志类型
	 * @author Galen
	 */
	public static interface LOGTYPE {
		/**增加*/
		public static String ADD = "0";
		/**修改*/
		public static String UPD = "1";
		/**删除*/
		public static String DEL = "2";
		/**复核*/
		public static String CHE = "3";
	}
	/**
	 * 操作模块
	 * @author Galen
	 */
	public static interface LOGMODEL {
		/**其他模块*/
		public static String OTHER = "0";
		/**操作员管理*/
		public static String UBASIC = "1";
		/**产品管理人管理*/
		public static String PRODUCTMANAGER = "2";
		/**机构管理*/
		public static String INVESTORORG = "3";
		/**字典管理*/
		public static String DICT = "4";
	}
	
	/**
	 * 操作动作
	 * @author Galen
	 */
	public static interface ACTION {
		/**页面跳转*/
		public static String PAGEUPDATE = "0";
		/**加入比较*/
		public static String COMPARE = "1";
	}
	
	/**
	 * 通知对象
	 * @author Galen
	 */
	public static interface OBJTYPE {
		/**操作员*/
		public static String OPERATE = "0";
		/**操客户经理*/
		public static String CUSTMANAGE = "1";
		/**运维人员*/
		public static String YUNWEI = "2";
	}
	
	/**
	 * 页面名称
	 * @author Galen
	 */
	public static interface PAGENAME {
		/**首页*/
		public static String HOME = "0";
		/**基金产品*/
		public static String PRODUCT = "1";
	}
	
}
