package com.yupi.springbootinit.model.dto.interfaceinfo;

import lombok.Data;
import java.io.Serializable;


/**
 * 创建请求
 *
 * @author 影歌
 * @from 影歌数字集团有限公司
 */
@Data
public class InterfaceInfoAddRequest implements Serializable {

    /**
     * 接口名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 请求参数
     */
    private String requestParams;

    /**
     * 接口地址
     */
    private String url;

    /**
     * 请求类型
     */
    private String method;

    /**
     * 请求头
     */
    private String requestHeader;

    /**
     * 响应头
     */
    private String responseHeader;

}