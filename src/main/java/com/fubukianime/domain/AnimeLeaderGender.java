package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("anime_leadergender")
public class AnimeLeaderGender {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("leader_gender")
    private String leaderGender;
}
