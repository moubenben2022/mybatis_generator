package com.mbb.mbg.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("element_path")
public class ElementPath implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "no", type = IdType.AUTO)
    private Integer no;

    /**
     * the xpath to get element(s) in the html got from url
     */
    @TableField("xpath")
    private String xpath;

    /**
     * the url to get page
     */
    @TableField("url")
    private String url;
}
