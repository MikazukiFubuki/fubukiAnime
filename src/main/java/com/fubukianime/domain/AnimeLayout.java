package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("anime_layout")
public class AnimeLayout {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("`layout_id`")
    private Integer layoutId;
    @TableField("layout_type_id")
    private Integer layoutTypeId;
    @TableField("another_name")
    private String anotherName;
    @TableField("quarter_num")
    private Integer quarterNum;
    @TableField("episodes")
    private Integer episodes;
}
