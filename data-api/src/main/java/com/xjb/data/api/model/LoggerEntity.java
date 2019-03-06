package com.xjb.data.api.model;

import lombok.Data;

import java.util.Date;

@Data
public class LoggerEntity {
    private Long id;

    private String clientip;

    private String uri;

    private String type;

    private String method;

    private String classmethod;

    private String sessionid;

    private String createby;

    private Date createtime;

    private Date returntime;

    private Integer timeconsuming;

    private String httpstatuscode;

    private String paramdata;

    private String exceptionmessage;


}