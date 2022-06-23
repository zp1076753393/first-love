package com.sparks.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author peng.zhou
 * @date Created in 2022/3/24 17:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity<ID extends Serializable> implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    protected ID id;

    @TableLogic
    protected Integer deleted;

}
