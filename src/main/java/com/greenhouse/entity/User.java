package com.greenhouse.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 用户表（包括普通管理员与普通职工）
 * </p>
 *
 * @author hjt
 * @since 2019-03-31
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    @TableId("user_id")
	private Long userId;
    /**
     * 手机号码
     */
	private String telephone;
    /**
     * 真实姓名
     */
	private String username;
    /**
     * 昵称
     */
	private String nickname;
    /**
     * 密码
     */
	private String password;
    /**
     * 邮箱
     */
	private String email;
    /**
     * 角色（0管理员，1员工，2超级管理员）
     */
	private Integer role;
    /**
     * 状态（0可用，1不可用）
     */
	private Integer status;
    /**
     * 对应管理员/超级管理员
     */
	private Long admin;
    /**
     * 备注
     */
	private String remark;
    /**
     * 创建时间
     */
	@TableField("gmt_created")
	private Date gmtCreated;
    /**
     * 修改时间
     */
	@TableField("gmt_modified")
	private Date gmtModified;


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getAdmin() {
		return admin;
	}

	public void setAdmin(Long admin) {
		this.admin = admin;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getGmtCreated() {
		return gmtCreated;
	}

	public void setGmtCreated(Date gmtCreated) {
		this.gmtCreated = gmtCreated;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	@Override
	protected Serializable pkVal() {
		return this.userId;
	}

	@Override
	public String toString() {
		return "User{" +
			", userId=" + userId +
			", telephone=" + telephone +
			", username=" + username +
			", nickname=" + nickname +
			", password=" + password +
			", email=" + email +
			", role=" + role +
			", status=" + status +
			", admin=" + admin +
			", remark=" + remark +
			", gmtCreated=" + gmtCreated +
			", gmtModified=" + gmtModified +
			"}";
	}
}
