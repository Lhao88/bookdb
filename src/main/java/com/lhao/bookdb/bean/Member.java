package com.lhao.bookdb.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;


/**
 * @TableName member
 */
@TableName(value = "member")
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
    private String idNumber;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}