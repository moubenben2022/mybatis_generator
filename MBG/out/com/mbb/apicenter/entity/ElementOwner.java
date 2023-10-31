package com.mbb.apicenter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author moubenben
 * @since 2023-10-27
 */
@Getter
@Setter
@TableName("element_owner")
public class ElementOwner implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "no", type = IdType.AUTO)
    private Integer no;

    @TableField("user_name")
    private String userName;

    /**
     * no in element_path
     */
    @TableField("element_no")
    private Integer elementNo;

    @TableField("creator")
    private String creator;

    @TableField("creat_time")
    private LocalDateTime creatTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableField("delete_time")
    private LocalDateTime deleteTime;

    @TableField("expire_time")
    private LocalDateTime expireTime;

    /**
     * 1 - is deleted
     */
    @TableField("is_deleted")
    private Integer isDeleted;

    /**
     * 1 - is expired
     */
    @TableField("is_expired")
    private Integer isExpired;
}
