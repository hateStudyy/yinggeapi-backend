package com.yingge.yinggeapi.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yingge.yinggecommon.model.entity.UserInterfaceInfo;

/**
* @author 123
* @description 针对表【user_interface_info(用户接口关系表)】的数据库操作Service
* @createDate 2023-07-31 15:13:01
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    void validUserInterfaceInfo(UserInterfaceInfo interfaceInfo, boolean add);

    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);

}
