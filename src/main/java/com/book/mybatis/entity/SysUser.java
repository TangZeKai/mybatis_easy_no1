package com.book.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户表
 */
@Data
public class SysUser {
//	private static final long serialVersionUID = -328602757171077630L;
    /**
     * 用户ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String userPassword;
    /**
     * 邮箱
     */
    private String userEmail;
    /**
     * 简介
     */
    private String userInfo;
    /**
     * 头像
     */
    private byte[] headImg;
    /**
     * 创建时间
     */
    private Date createTime;

//	/**
//	 * 用户角色
//	 */
//	private SysRole role;

//	/**
//	 * 用户的角色集合
//	 */
//	private List<SysRole> roleList;


    public SysUser() {//这个空参没有就报错 懵逼
    }

    public SysUser(Long id) {
        this.id = id;
    }

    public SysUser(String userName, String userPassword, String userEmail, String userInfo, byte[] headImg, Date createTime) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userInfo = userInfo;
        this.headImg = headImg;
        this.createTime = createTime;
    }

    public SysUser(Long id, String userName, String userPassword, String userEmail, String userInfo, byte[] headImg, Date createTime) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userInfo = userInfo;
        this.headImg = headImg;
        this.createTime = createTime;
    }
}
