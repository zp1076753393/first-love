package com.sparks.user.controller;

import com.sparks.common.result.WebResult;
import com.sparks.common.vo.res.UserRes;
import com.sparks.user.entity.UserEntity;
import com.sparks.user.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author peng.zhou
 * @date Created in 2022/3/24 17:21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    public WebResult<UserRes> getUser(@PathVariable("id") Long id) {
        UserEntity entity = userService.getById(id);
        UserRes res = new UserRes();
        BeanUtils.copyProperties(entity, res);
        return new WebResult<>(200, "success", res);
    }

}
