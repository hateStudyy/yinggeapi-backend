package com.yingge.yinggeapi.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yingge.yinggecommon.model.entity.InterfaceInfo;
import com.yingge.yinggeapi.model.dto.interfaceinfo.InterfaceInfoQueryRequest;

/**
* @author 123
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-07-27 17:07:21
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

    QueryWrapper<InterfaceInfo> getQueryWrapper(InterfaceInfoQueryRequest interfaceInfoQueryRequest);


}
