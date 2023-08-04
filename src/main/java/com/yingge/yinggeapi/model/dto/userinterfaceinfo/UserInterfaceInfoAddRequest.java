package com.yingge.yinggeapi.model.dto.userinterfaceinfo;

import lombok.Data;

import java.io.Serializable;


/**
 * 创建请求
 *
 * @author 影歌
 * @from 影歌数字集团有限公司
 */
@Data
public class UserInterfaceInfoAddRequest implements Serializable {

    /**
     * 调用用户 id
     */
    private Long userId;

    /**
     * 被调用接口 id
     */
    private Long interfaceInfoId;

    /**
     * 总调用次数
     */
    private Integer totalNum;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;

}