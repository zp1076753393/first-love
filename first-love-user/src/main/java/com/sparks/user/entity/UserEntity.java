package com.sparks.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sparks.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author peng.zhou
 * @date Created in 2022/3/24 16:58
 */
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("u_user")
public class UserEntity extends BaseEntity<Long> {

    private String userName;

    private String loginName;

    private String password;

    private String phone;

}
