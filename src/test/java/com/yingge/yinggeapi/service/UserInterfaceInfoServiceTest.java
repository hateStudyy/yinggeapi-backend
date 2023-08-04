package com.yingge.yinggeapi.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author ckl
 * @since 2023/7/31 16:24
 */
@SpringBootTest
public class UserInterfaceInfoServiceTest {


    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Test
    void invokeCount() {
        boolean b = userInterfaceInfoService.invokeCount(1, 1);
        Assertions.assertTrue(b);
    }
}