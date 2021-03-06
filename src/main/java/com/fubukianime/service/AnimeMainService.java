package com.fubukianime.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeLayout;
import com.fubukianime.domain.AnimeLove;
import com.fubukianime.domain.AnimeMain;
import com.fubukianime.domain.AnimeMain;
import com.fubukianime.entity.PageResult;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
* @author wyx
* @description 针对表【anime_main】的数据库操作Service
* @createDate 2022-07-14 15:07:06
*/
public interface AnimeMainService extends IService<AnimeMain> {

    /**
     * 新增动画
     * @param animeMain
     * @return
     */
    boolean addAnime(AnimeMain animeMain);

    /**
     * 对已有动画新增形式
     * @param id
     */
    boolean addAnimeLayoutById(Integer id);

    /**
     * 开始追番，修改动画信息
     * @param animeMain
     */
    boolean startAnime(AnimeMain animeMain);

    /**
     * 增加动画来源
     * @param animeMain
     */
    boolean addSource(AnimeMain animeMain);

    /**
     * 番剧补完，修改动画信息
     * @param animeMain
     */
    boolean endAnime(AnimeMain animeMain);

    /**
     * 对已追动画修改它的形式
     * @param animeLayout
     */
    boolean saveLayout(AnimeLayout animeLayout);

    /**
     * 番剧重温
     * @param id
     */
    boolean reviewAnime(Integer id);

    boolean delete(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    AnimeMain selectMainById(Integer id);

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage<AnimeMain> getPage(int currentPage, int pageSize);

    /**
     * 全部分页查询
     * @param currentPage
     * @param pageSize
     * @param animeMain
     * @return
     */
    IPage<AnimeMain> getPage(int currentPage, int pageSize, AnimeMain animeMain);

    /**
     * 条件查询
     * @param
     * @return
     */
    PageInfo<AnimeMain> selectByCondition(Integer pageNum, Integer pageSize, AnimeMain animeMain);


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
     * 修改追番、补番、重温序号
     * @param
     * @return
     */
    boolean updateCompleteId(AnimeMain animeMain);













}
