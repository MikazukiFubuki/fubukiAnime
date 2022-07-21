package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("anime_layout_type")
public class AnimeLayoutType {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("layout_type")
    private String layoutType;
}
