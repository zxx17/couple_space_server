package com.zxx17.couple.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户表
 * @TableName cp_user
 */
@TableName(value ="cp_user")
@Data
public class CpUser implements Serializable {
    /**
     * 用户唯一ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 个人介绍
     */
    private String personalIntroduction;

    /**
     * 头像URL
     */
    private String avatarUrl;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 身份证号
     */
    private String idCardNumber;

    /**
     * 性别，1-男，2-女，3-其他
     */
    private Integer gender;

    /**
     * 是否单身，1-是，0-否
     */
    private Integer isSingle;

    /**
     * 会员等级，0-普通会员，1-银卡，2-金卡，3-钻石
     */
    private Integer membershipLevel;

    /**
     * 最近登录时间
     */
    private Date lastLoginTime;

    /**
     * 最近登录地址
     */
    private String lastLoginIp;

    /**
     * 注册时间
     */
    private Date registrationTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 用户状态，1-正常，0-禁用
     */
    private Integer userStatus;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CpUser other = (CpUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getPersonalIntroduction() == null ? other.getPersonalIntroduction() == null : this.getPersonalIntroduction().equals(other.getPersonalIntroduction()))
            && (this.getAvatarUrl() == null ? other.getAvatarUrl() == null : this.getAvatarUrl().equals(other.getAvatarUrl()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getIdCardNumber() == null ? other.getIdCardNumber() == null : this.getIdCardNumber().equals(other.getIdCardNumber()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getIsSingle() == null ? other.getIsSingle() == null : this.getIsSingle().equals(other.getIsSingle()))
            && (this.getMembershipLevel() == null ? other.getMembershipLevel() == null : this.getMembershipLevel().equals(other.getMembershipLevel()))
            && (this.getLastLoginTime() == null ? other.getLastLoginTime() == null : this.getLastLoginTime().equals(other.getLastLoginTime()))
            && (this.getLastLoginIp() == null ? other.getLastLoginIp() == null : this.getLastLoginIp().equals(other.getLastLoginIp()))
            && (this.getRegistrationTime() == null ? other.getRegistrationTime() == null : this.getRegistrationTime().equals(other.getRegistrationTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUserStatus() == null ? other.getUserStatus() == null : this.getUserStatus().equals(other.getUserStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getPersonalIntroduction() == null) ? 0 : getPersonalIntroduction().hashCode());
        result = prime * result + ((getAvatarUrl() == null) ? 0 : getAvatarUrl().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getIdCardNumber() == null) ? 0 : getIdCardNumber().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getIsSingle() == null) ? 0 : getIsSingle().hashCode());
        result = prime * result + ((getMembershipLevel() == null) ? 0 : getMembershipLevel().hashCode());
        result = prime * result + ((getLastLoginTime() == null) ? 0 : getLastLoginTime().hashCode());
        result = prime * result + ((getLastLoginIp() == null) ? 0 : getLastLoginIp().hashCode());
        result = prime * result + ((getRegistrationTime() == null) ? 0 : getRegistrationTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUserStatus() == null) ? 0 : getUserStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", nickname=").append(nickname);
        sb.append(", personalIntroduction=").append(personalIntroduction);
        sb.append(", avatarUrl=").append(avatarUrl);
        sb.append(", password=").append(password);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", email=").append(email);
        sb.append(", idCardNumber=").append(idCardNumber);
        sb.append(", gender=").append(gender);
        sb.append(", isSingle=").append(isSingle);
        sb.append(", membershipLevel=").append(membershipLevel);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", lastLoginIp=").append(lastLoginIp);
        sb.append(", registrationTime=").append(registrationTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", userStatus=").append(userStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}