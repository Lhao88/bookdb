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
 * @TableName member
 */
@TableName(value ="member")
@Data
public class Member implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String mName;

    /**
     * 
     */
    private String pwd;

    /**
     * 
     */
    private Integer typeId;

    /**
     * 
     */
    private Double balance;

    /**
     * 
     */
    private Date regdate;

    /**
     * 
     */
    private String tel;

    /**
     * 
     */
    private String idnumber;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}