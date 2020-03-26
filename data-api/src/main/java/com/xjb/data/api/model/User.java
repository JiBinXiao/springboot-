package com.xjb.data.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ApiModel("任务-风险分类统计实体-请求传参")
public class User implements Serializable {
    @ApiModelProperty(value = "主键", required = false)
    private Integer id;
    @ApiModelProperty(value = "用户名", required = false)
    private String username;
    @ApiModelProperty(value = "密码", required = false)
    private String password;
    @ApiModelProperty(value = "创建时间", required = false, readOnly = true, hidden = true)
    private Date ctime;
    @ApiModelProperty(value = "修改时间", required = false, readOnly = true, hidden = true)
    private Date utime;
    @ApiModelProperty(value = "状态", required = false, readOnly = true, hidden = true)
    private Integer st;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public Integer getSt() {
        return st;
    }

    public void setSt(Integer st) {
        this.st = st;
    }
}