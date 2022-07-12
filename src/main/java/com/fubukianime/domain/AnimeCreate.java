package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("anime_create")
public class AnimeCreate {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("`create`")
    private String create;
    private String description;
}
