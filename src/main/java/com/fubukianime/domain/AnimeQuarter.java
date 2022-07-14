package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("anime_quarter")
public class AnimeQuarter {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("quarter")
    private String quarter;
}
