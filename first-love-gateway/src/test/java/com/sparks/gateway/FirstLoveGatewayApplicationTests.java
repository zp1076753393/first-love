package com.sparks.gateway;

import com.sparks.common.feign.UserFeign;
import com.sparks.common.result.WebResult;
import com.sparks.common.vo.res.UserRes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FirstLoveGatewayApplicationTests {

    @Autowired
    private UserFeign userFeign;

    @Test
    void contextLoads() {
        WebResult<UserRes> res = userFeign.getUser(1L);
        System.out.println("res: " + res.getMessage());
    }

}
