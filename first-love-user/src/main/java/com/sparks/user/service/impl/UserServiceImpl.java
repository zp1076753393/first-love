package com.sparks.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sparks.user.dao.UserDao;
import com.sparks.user.entity.UserEntity;
import com.sparks.user.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author peng.zhou
 * @date Created in 2022/3/24 17:27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity>
        implements IUserService {
}
