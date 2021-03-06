package com.fubukianime.dao;


import com.alibaba.druid.Constants;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fubukianime.domain.AnimeLayout;
import com.fubukianime.domain.AnimeMain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* @author wyx
* @description 针对表【anime_main】的数据库操作Mapper
* @createDate 2022-07-14 15:07:06
* @Entity generator.domain.AnimeMain
*/
@Mapper
public interface AnimeMainDao extends BaseMapper<AnimeMain> {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    AnimeMain selectMainById(Integer id);

    /**
     * 查询全部并分页
     * @param page
     * @return
     */
    IPage<AnimeMain> selectMainAll(Page<AnimeMain> page);

    /**
     * 条件查询
     * @param
     * @return
     */
    List<AnimeMain> selectMainByCondition(AnimeMain animeMain);

    /**
     * 新增动画
     * @param animeMain
     */
    void addAnime(AnimeMain animeMain);

    /**
     * 新增动画同时新增对应id形式
     *
     */
    void addAnimeLayout();


    /**
     * 对已有动画新增形式
     * @param id
     */
    void addAnimeLayoutById(Integer id);

    /**
     * 开始追番，修改动画信息
     * @param animeMain
     */
    void startAnime(AnimeMain animeMain);

    /**
     * 增加动画来源
     * @param animeMain
     */
    void addSource(AnimeMain animeMain);

    /**
     * 番剧补完，修改动画信息
     * @param animeMain
     */
    void endAnime(AnimeMain animeMain);

    /**
     * 番剧重温
     * @param id
     */
    void reviewAnime(Integer id);

    /**
     * 对已追动画修改它的形式
     * @param animeLayout
     */
    void saveLayout(AnimeLayout animeLayout);

    /**
     * 查找要修改动画的全部形式
     * @param id
     * @return
     */
    List<AnimeLayout> selectAnimeLayoutByAnimeId(Integer id);

    /**
     * 根据要修改动画的形式id查询
     * @param id
     * @return
     */
    AnimeLayout selectLayoutById(Integer id);

    /**
     * 根据id修改补番序号
     * @param animeMain
     */
    void updateCompleteId(AnimeMain animeMain);

    /**
     * 根据追番、补番、重温序号查找id
     * @param
     * @return
     */
    Integer selectIdByBCRId(AnimeMain animeMain);




}
