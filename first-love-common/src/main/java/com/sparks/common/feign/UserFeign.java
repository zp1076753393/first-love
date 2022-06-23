package com.sparks.common.feign;

import com.sparks.common.result.WebResult;
import com.sparks.common.vo.res.UserRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author peng.zhou
 * @date Created in 2022/3/24 17:31
 */
@FeignClient("first-love-user")
public interface UserFeign {

    /**
     * 获取用户信息
     *
     * @param id id
     * @return 用户信息
     */
    @GetMapping("/user/{id}")
    WebResult<UserRes> getUser(@PathVariable("id") Long id);

}
