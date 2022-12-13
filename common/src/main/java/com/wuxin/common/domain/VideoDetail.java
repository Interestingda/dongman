package com.wuxin.common.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import net.sf.jsqlparser.statement.alter.ValidateConstraint;

import static com.baomidou.mybatisplus.annotation.IdType.INPUT;

/**
 * Atothor:aa
 * data:2022/10/24
 */
@TableName("t_videodetail")
public class VideoDetail {


    private String vod_pic;
   @TableField(value = "vod_id")
   @TableId(type = INPUT)
    private Long vod_id;

    @TableField(value ="detailInfo")
    private String detailInfo;


    public VideoDetail() {
    }

    public VideoDetail(Long vod_id, String detailInfo, String vod_pic) {
        this.vod_id = vod_id;
        this.detailInfo = detailInfo;
        this.vod_pic = vod_pic;
    }

    public String getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }

    public String getVod_pic() {
        return vod_pic;
    }

    public void setVod_pic(String vod_pic) {
        this.vod_pic = vod_pic;
    }

    public Long getVod_id() {
        return vod_id;
    }

    public void setVod_id(Long vod_id) {
        this.vod_id = vod_id;
    }

    @Override
    public String toString() {
        return "VideoDetail{" +
                "vod_pic='" + vod_pic + '\'' +
                ", vod_id=" + vod_id +
                ", detailInfo='" + detailInfo + '\'' +
                '}';
    }
}
