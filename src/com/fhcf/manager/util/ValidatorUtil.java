package com.fhcf.manager.util;

import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.puff.framework.utils.StringUtil;
import com.puff.web.mvc.PuffContext;

public class ValidatorUtil {
	public static boolean isDigit(String str) {
		if (StringUtil.empty(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher match = pattern.matcher(str);
		return match.matches();
	}
	public static boolean isdate(String str){
		if (StringUtil.empty(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^((?:19|20)\\d\\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$");
		Matcher match = pattern.matcher(str);
		return match.matches();
		
	}
	public static boolean isMoney(String str) {
		Pattern pattern = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$");
		Matcher match = pattern.matcher(str);
		if (match.matches()) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isMobile(String str) {
		Pattern p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
		Matcher m = p.matcher(str);
		return m.matches();
	}

	/**
	 * 电话号码验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isPhone(String str) {
		Matcher m = null;
		Pattern p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$"); // 验证带区号的
		Pattern p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$"); // 验证没有区号的
		if (str.length() > 9) {
			m = p1.matcher(str);
			return m.matches();
		} else {
			m = p2.matcher(str);
			return m.matches();
		}
	}

	public static boolean ismebill(String str) {
		Matcher m = null;
		Pattern p1 = Pattern.compile("^1[3|4|5|7|8]\\d{9}$");
		m = p1.matcher(str);
		return m.matches();
	}

	private static final String EMAIL_ADDRESS_PATTERN = "\\b(^['_A-Za-z0-9-]+(\\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";

	public static boolean isEmail(String value) {
		Pattern pattern = Pattern.compile(EMAIL_ADDRESS_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}

	public static boolean isIpAddr(String ip) {
		Pattern pattern = Pattern
				.compile("\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b");
		Matcher matcher = pattern.matcher(ip);
		return matcher.matches();
	}

	public static boolean isUrl(String url) {
		boolean flag = false;
		int counts = 0;
		if (StringUtil.empty(url)) {
			return flag;
		}
		while (counts < 2) {
			try {
				HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
				int state = connection.getResponseCode();
				if (state == 200) {
					flag = true;
				}
				break;
			} catch (Exception e) {
				counts++;
			}
		}
		return flag;
	}

	/**
	 * 校验银行卡卡号
	 * 
	 * @param cardId
	 * @return
	 */

	public static boolean isBankCard(String cardId) {
		char bit = getBankCardCheckCode(cardId.substring(0, cardId.length() - 1));
		if (bit == 'N') {
			return false;
		}
		return cardId.charAt(cardId.length() - 1) == bit;
	}

	/**
	 * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位
	 * 
	 * @param nonCheckCodeCardId
	 * @return
	 */
	public static char getBankCardCheckCode(String nonCheckCodeCardId) {
		if (nonCheckCodeCardId == null || nonCheckCodeCardId.trim().length() == 0 || !nonCheckCodeCardId.matches("\\d+")) {
			// 如果传的不是数据返回N
			return 'N';
		}
		char[] chs = nonCheckCodeCardId.trim().toCharArray();
		int luhmSum = 0;
		for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
			int k = chs[i] - '0';
			if (j % 2 == 0) {
				k *= 2;
				k = k / 10 + k % 10;
			}
			luhmSum += k;
		}
		return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
	}

	// 验证码校验
	public static boolean equalCheckCode(String checkcode) {
		String rcode = (String) PuffContext.getSessionAttribute("rcode");
		if (!checkcode.equals(rcode)) {
			return false;
		}
		return true;
	}

	// 密码格式校验
	public static boolean isPassword(String passwd) {
		Pattern p = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,18}$");
		Matcher m = p.matcher(passwd);
		return m.matches();
	}

	/**
	 * @Title: NumberHandle
	 * @Description: 处理小数位(必须是小数字符)
	 * @param Num
	 *            字符数字
	 * @param scale
	 *            保留位数,位数不够补0
	 * @param b
	 *            true四舍五入 false 截掉
	 * @throws
	 */
	public static String NumberHandle(String Num, int scale, boolean b) {
		String val = "";
		try {
			BigDecimal bd = new BigDecimal(Num);
			int roundingMode = b ? 4 : 1;
			bd = bd.setScale(scale, roundingMode);
			val = String.valueOf(bd.floatValue());
		} catch (Exception e) {
			return null;
		}
		int len = val.substring(val.indexOf(".") + 1).length();
		if (len < scale) {
			for (int i = 0, leng = scale - len; i < leng; i++) {
				val += 0;
			}
		}
		return val;
	}

	/**
	 * @Title: Numeq
	 * @Description: 比较num1是否大于等于num2
	 * @param num1
	 * @param num2
	 * @throws
	 */
	public static boolean Numeq(String num1, String num2) {
		boolean b = false;
		try {
			b = Float.valueOf(num1) >= Float.valueOf(num2);
		} catch (NumberFormatException e) {
			b = false;
		}
		return b;
	}

	/**
	 * 比对验证码
	 * 
	 * @param client
	 *            画面端
	 * @param server
	 *            服务器端
	 */
	public static boolean checkCode(String client, String server) {
		return client.toUpperCase().equals(server.toUpperCase());
	}

	public static boolean equals(String value, String target) {
		if (StringUtil.hasEmpty(value, target)) {
			return false;
		}
		return value.equals(target);
	}

	public static boolean equalsIgnoreCase(String value, String target) {
		if (StringUtil.hasEmpty(value, target)) {
			return false;
		}
		return value.equalsIgnoreCase(target);
	}
	
}
