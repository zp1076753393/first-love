package com.sparks.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sparks.user.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * @author peng.zhou
 * @date Created in 2022/3/24 17:21
 */
@Repository
public interface UserDao extends BaseMapper<UserEntity> {
}
