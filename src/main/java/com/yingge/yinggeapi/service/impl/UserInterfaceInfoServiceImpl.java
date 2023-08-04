package com.yingge.yinggeapi.service.impl;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingge.yinggecommon.model.entity.UserInterfaceInfo;
import com.yingge.yinggeapi.common.ErrorCode;
import com.yingge.yinggeapi.exception.BusinessException;
import com.yingge.yinggeapi.mapper.UserInterfaceInfoMapper;
import com.yingge.yinggeapi.service.UserInterfaceInfoService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author 123
* @description 针对表【user_interface_info(用户接口关系表)】的数据库操作Service实现
* @createDate 2023-07-31 15:13:01
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {


        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Long id = userInterfaceInfo.getId();
        Integer status = userInterfaceInfo.getStatus();
        Long userId = userInterfaceInfo.getUserId();
        Date createTime = userInterfaceInfo.getCreateTime();
        Date updateTime = userInterfaceInfo.getUpdateTime();
        Integer isDelete = userInterfaceInfo.getIsDelete();
        // 创建时，参数不能为空
        if (add) {
            if(userInterfaceInfo.getInterfaceInfoId() <= 0 || userInterfaceInfo.getUserId() <= 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口和用户不存在");
            }
        }
        // 有参数则校验
        if (userInterfaceInfo.getLeftNum() < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数不能小于0");
        }

    }



    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        // 校验
        if (interfaceInfoId < 0 || userId < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("interfaceInfoId", interfaceInfoId);
        updateWrapper.eq("userId", userId);
        // updateWrapper.gt("leftNum", 0);
        // todo 加sync锁 分布式要加分布式锁
        updateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
        return this.update(updateWrapper);
    }
}




