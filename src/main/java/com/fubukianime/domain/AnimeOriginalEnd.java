package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("anime_originalend")
public class AnimeOriginalEnd {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("original_end")
    private String originalEnd;
}
