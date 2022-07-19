package com.fubukianime.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
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

    boolean save(AnimeMain animeMain);

    boolean modify(AnimeMain animeMain);

    boolean delete(Integer id);

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

    PageInfo<AnimeMain> selectByCondition(Integer pageNum, Integer pageSize, AnimeMain animeMain);













}
