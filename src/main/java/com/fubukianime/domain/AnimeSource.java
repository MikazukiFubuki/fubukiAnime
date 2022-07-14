package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("anime_source")
public class AnimeSource {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("source")
    private String source;
    @TableField("`debut`")
    private String debut;
}
