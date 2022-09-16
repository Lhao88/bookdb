package com.lhao.bookdb.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName book
 */
@TableName(value ="book")
@Data
public class Book implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer typeId;

    /**
     * 
     */
    private String bName;

    /**
     * 
     */
    private Double price;

    /**
     * 
     */
    private String bDesc;

    /**
     * 
     */
    private String pic;

    /**
     * 
     */
    private String publish;

    /**
     * 
     */
    private String author;

    /**
     * 
     */
    private Integer stock;

    /**
     * 
     */
    private String address;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}