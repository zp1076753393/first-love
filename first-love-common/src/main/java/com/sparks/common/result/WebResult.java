package com.sparks.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author peng.zhou
 * @date Created in 2022/3/24 17:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebResult<T> {

    /**
     * 响应代码
     */
    private Integer status;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应结果
     */
    private T result;

}
