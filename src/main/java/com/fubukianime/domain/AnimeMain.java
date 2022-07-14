package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName anime_main
 */
@TableName(value ="anime_main")
@Data
public class AnimeMain implements Serializable {
    /**
     * 动画表id（主键）
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 动画片名
     */
    private String name;

    /**
     * 动画评分
     */
    private Double score;

    /**
     * 动画片源1
     */
    @TableField("source_1")
    private String source1;

    /**
     * 动画片源2
     */
    @TableField("source_2")
    private String source2;

    /**
     * 动画片源3
     */
    @TableField("source_3")
    private String source3;

    /**
     * 动画类型1
     */
    @TableField("type_1")
    private String type1;

    /**
     * 动画类型2
     */
    @TableField("type_2")
    private String type2;

    /**
     * 动画类型3
     */
    @TableField("type_3")
    private String type3;

    /**
     * 动画补完序号
     */
    @TableField("complete_id")
    private Integer completeId;

    /**
     * 动画追番情况
     */
    @TableField("binge_watching_type")
    private String bingeWatchingType;

    /**
     * 动画原作结局
     */
    @TableField("original_end")
    private String originalEnd;

    /**
     * 动画状态
     */
    private String status;

    /**
     * 动画播出最终年份
     */
    @TableField("broadcast_end_year")
    @JsonFormat(pattern = "yyyy",timezone = "GMT+8")
    private Object broadcastEndYear;

    /**
     * 动画最爱女主
     */
    @TableField("favorite_heroine")
    private String favoriteHeroine;

    /**
     * 动画追番序号
     */
    @TableField("binge_watching_id")
    private Integer bingeWatchingId;

    /**
     * 动画创作类型
     */
    @TableField("`create`")
    private String create;

    /**
     * 动画工口类型
     */
    @TableField("sex_limit")
    private String sexLimit;

    /**
     * 动画补完季
     */
    @TableField("complete_quarter")
    private String completeQuarter;

    /**
     * 动画追番季
     */
    @TableField("binge_watching_quarter")
    private String bingeWatchingQuarter;

    /**
     * 动画播出起始年份
     */
    @TableField("broadcast_start_year")
    @JsonFormat(pattern = "yyyy",timezone = "GMT+8")
    private Object broadcastStartYear;

    /**
     * 动画结局
     */
    @TableField("animation_end")
    private String animationEnd;

    /**
     * 动画主角类型
     */
    @TableField("leader_gender")
    private String leaderGender;

    /**
     * 动画重温序号
     */
    @TableField("review_id")
    private Integer reviewId;

    /**
     * 动画恋爱类型
     */
    private String love;

    /**
     * 动画形式
     */
    @TableField("layout_id")
    private String layoutId;

    /*@TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AnimeMain other = (AnimeMain) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getSource1() == null ? other.getSource1() == null : this.getSource1().equals(other.getSource1()))
            && (this.getSource2() == null ? other.getSource2() == null : this.getSource2().equals(other.getSource2()))
            && (this.getSource3() == null ? other.getSource3() == null : this.getSource3().equals(other.getSource3()))
            && (this.getType1() == null ? other.getType1() == null : this.getType1().equals(other.getType1()))
            && (this.getType2() == null ? other.getType2() == null : this.getType2().equals(other.getType2()))
            && (this.getType3() == null ? other.getType3() == null : this.getType3().equals(other.getType3()))
            && (this.getCompleteId() == null ? other.getCompleteId() == null : this.getCompleteId().equals(other.getCompleteId()))
            && (this.getBingeWatchingType() == null ? other.getBingeWatchingType() == null : this.getBingeWatchingType().equals(other.getBingeWatchingType()))
            && (this.getOriginalEnd() == null ? other.getOriginalEnd() == null : this.getOriginalEnd().equals(other.getOriginalEnd()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBroadcastEndYear() == null ? other.getBroadcastEndYear() == null : this.getBroadcastEndYear().equals(other.getBroadcastEndYear()))
            && (this.getFavoriteHeroine() == null ? other.getFavoriteHeroine() == null : this.getFavoriteHeroine().equals(other.getFavoriteHeroine()))
            && (this.getBingeWatchingId() == null ? other.getBingeWatchingId() == null : this.getBingeWatchingId().equals(other.getBingeWatchingId()))
            && (this.getCreate() == null ? other.getCreate() == null : this.getCreate().equals(other.getCreate()))
            && (this.getSexLimit() == null ? other.getSexLimit() == null : this.getSexLimit().equals(other.getSexLimit()))
            && (this.getCompleteQuarter() == null ? other.getCompleteQuarter() == null : this.getCompleteQuarter().equals(other.getCompleteQuarter()))
            && (this.getBingeWatchingQuarter() == null ? other.getBingeWatchingQuarter() == null : this.getBingeWatchingQuarter().equals(other.getBingeWatchingQuarter()))
            && (this.getBroadcastStartYear() == null ? other.getBroadcastStartYear() == null : this.getBroadcastStartYear().equals(other.getBroadcastStartYear()))
            && (this.getAnimationEnd() == null ? other.getAnimationEnd() == null : this.getAnimationEnd().equals(other.getAnimationEnd()))
            && (this.getLeaderGender() == null ? other.getLeaderGender() == null : this.getLeaderGender().equals(other.getLeaderGender()))
            && (this.getReviewId() == null ? other.getReviewId() == null : this.getReviewId().equals(other.getReviewId()))
            && (this.getLove() == null ? other.getLove() == null : this.getLove().equals(other.getLove()))
            && (this.getLayoutId() == null ? other.getLayoutId() == null : this.getLayoutId().equals(other.getLayoutId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getSource1() == null) ? 0 : getSource1().hashCode());
        result = prime * result + ((getSource2() == null) ? 0 : getSource2().hashCode());
        result = prime * result + ((getSource3() == null) ? 0 : getSource3().hashCode());
        result = prime * result + ((getType1() == null) ? 0 : getType1().hashCode());
        result = prime * result + ((getType2() == null) ? 0 : getType2().hashCode());
        result = prime * result + ((getType3() == null) ? 0 : getType3().hashCode());
        result = prime * result + ((getCompleteId() == null) ? 0 : getCompleteId().hashCode());
        result = prime * result + ((getBingeWatchingType() == null) ? 0 : getBingeWatchingType().hashCode());
        result = prime * result + ((getOriginalEnd() == null) ? 0 : getOriginalEnd().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBroadcastEndYear() == null) ? 0 : getBroadcastEndYear().hashCode());
        result = prime * result + ((getFavoriteHeroine() == null) ? 0 : getFavoriteHeroine().hashCode());
        result = prime * result + ((getBingeWatchingId() == null) ? 0 : getBingeWatchingId().hashCode());
        result = prime * result + ((getCreate() == null) ? 0 : getCreate().hashCode());
        result = prime * result + ((getSexLimit() == null) ? 0 : getSexLimit().hashCode());
        result = prime * result + ((getCompleteQuarter() == null) ? 0 : getCompleteQuarter().hashCode());
        result = prime * result + ((getBingeWatchingQuarter() == null) ? 0 : getBingeWatchingQuarter().hashCode());
        result = prime * result + ((getBroadcastStartYear() == null) ? 0 : getBroadcastStartYear().hashCode());
        result = prime * result + ((getAnimationEnd() == null) ? 0 : getAnimationEnd().hashCode());
        result = prime * result + ((getLeaderGender() == null) ? 0 : getLeaderGender().hashCode());
        result = prime * result + ((getReviewId() == null) ? 0 : getReviewId().hashCode());
        result = prime * result + ((getLove() == null) ? 0 : getLove().hashCode());
        result = prime * result + ((getLayoutId() == null) ? 0 : getLayoutId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", score=").append(score);
        sb.append(", source1=").append(source1);
        sb.append(", source2=").append(source2);
        sb.append(", source3=").append(source3);
        sb.append(", type1=").append(type1);
        sb.append(", type2=").append(type2);
        sb.append(", type3=").append(type3);
        sb.append(", completeId=").append(completeId);
        sb.append(", bingeWatchingType=").append(bingeWatchingType);
        sb.append(", originalEnd=").append(originalEnd);
        sb.append(", status=").append(status);
        sb.append(", broadcastEndYear=").append(broadcastEndYear);
        sb.append(", favoriteHeroine=").append(favoriteHeroine);
        sb.append(", bingeWatchingId=").append(bingeWatchingId);
        sb.append(", create=").append(create);
        sb.append(", sexLimit=").append(sexLimit);
        sb.append(", completeQuarter=").append(completeQuarter);
        sb.append(", bingeWatchingQuarter=").append(bingeWatchingQuarter);
        sb.append(", broadcastStartYear=").append(broadcastStartYear);
        sb.append(", animationEnd=").append(animationEnd);
        sb.append(", leaderGender=").append(leaderGender);
        sb.append(", reviewId=").append(reviewId);
        sb.append(", love=").append(love);
        sb.append(", layoutId=").append(layoutId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }*/
}