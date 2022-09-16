package com.lhao.bookdb.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName membertype
 */
@TableName(value ="membertype")
@Data
public class Membertype implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String mtName;

    /**
     * 
     */
    private Integer amount;

    /**
     * 
     */
    private Integer discount;

    /**
     * 
     */
    private Integer recharge;

    /**
     * 
     */
    private Integer keepday;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}