package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("anime_bingewatchingtype")
public class AnimeBingeWatchingType {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("binge_watching_type")
    private String bingeWatchingType;
}
