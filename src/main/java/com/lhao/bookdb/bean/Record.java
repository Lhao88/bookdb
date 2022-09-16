package com.lhao.bookdb.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName record
 */
@TableName(value ="record")
@Data
public class Record implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer memberId;

    /**
     * 
     */
    private Integer bookId;

    /**
     * 
     */
    private Date rentdate;

    /**
     * 
     */
    private Date backdate;

    /**
     * 
     */
    private Double deposit;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private String isbn;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}