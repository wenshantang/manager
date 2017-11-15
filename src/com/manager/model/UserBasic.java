package com.manager.model;

import com.puff.framework.annotation.Column;
import com.puff.framework.annotation.Table;

import com.puff.framework.annotation.PrimaryKey;

import cn.aresoft.common.model.BaseModel;

@Table("USER_BASIC")
public class UserBasic extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 614175932606410339L;
	@PrimaryKey.IDWORKER
	@Column
	private String id;
	@Column
	private String real_name;
	@Column
	private String gender;
	@Column
	private String password;
	@Column
	private String mobile;
	@Column
	private String card_type;
	@Column
	private String card_code;
	@Column
	private String card_time;
	@Column
	private String o_id;
	@Column
	private String position;
	@Column
	private String email;
	@Column
	private String tel_phone;
	@Column
	private String fax_num;
	@Column
	private String address;
	@Column
	private String post_card;
	@Column
	private String cm_id;//废弃
	@Column
	private String status;
	/**
	 * 密码初始化标识
	 * 0：非初始的，1：初始的
	 */
	@Column
	private String pwdinit_flag;
	@Column
	private String check_status;
	@Column
	private String check_code;
	@Column
	private String create_time;
	@Column
	private String create_code;
	@Column
	private String update_time;
	@Column
	private String update_code;
	
	private String gener_id;
	
	
	public String getGener_id() {
		return gener_id;
	}
	public void setGener_id(String gener_id) {
		this.gener_id = gener_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public String getCard_code() {
		return card_code;
	}
	public void setCard_code(String card_code) {
		this.card_code = card_code;
	}
	public String getCard_time() {
		return card_time;
	}
	public void setCard_time(String card_time) {
		this.card_time = card_time;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel_phone() {
		return tel_phone;
	}
	public void setTel_phone(String tel_phone) {
		this.tel_phone = tel_phone;
	}
	public String getFax_num() {
		return fax_num;
	}
	public void setFax_num(String fax_num) {
		this.fax_num = fax_num;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPwdinit_flag() {
		return pwdinit_flag;
	}
	public void setPwdinit_flag(String pwdinit_flag) {
		this.pwdinit_flag = pwdinit_flag;
	}
	public String getCheck_status() {
		return check_status;
	}
	public void setCheck_status(String check_status) {
		this.check_status = check_status;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getO_id() {
		return o_id;
	}
	public void setO_id(String o_id) {
		this.o_id = o_id;
	}
	public String getCheck_code() {
		return check_code;
	}
	public void setCheck_code(String check_code) {
		this.check_code = check_code;
	}
	public String getCreate_code() {
		return create_code;
	}
	public void setCreate_code(String create_code) {
		this.create_code = create_code;
	}
	public String getUpdate_code() {
		return update_code;
	}
	public void setUpdate_code(String update_code) {
		this.update_code = update_code;
	}
	public String getPost_card() {
		return post_card;
	}
	public void setPost_card(String post_card) {
		this.post_card = post_card;
	}
	public String getCm_id() {
		return cm_id;
	}
	public void setCm_id(String cm_id) {
		this.cm_id = cm_id;
	}
	
}
