package com.sparks.common.vo.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author peng.zhou
 * @date Created in 2022/3/24 17:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRes {

    private Long id;

    private String userName;

    private String loginName;

    private String password;

    private String phone;

}
