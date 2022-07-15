package com.fubukianime.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeMain;
import com.fubukianime.domain.AnimeMain;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
* @author wyx
* @description 针对表【anime_main】的数据库操作Service
* @createDate 2022-07-14 15:07:06
*/
public interface AnimeMainService extends IService<AnimeMain> {

    boolean saveMain(AnimeMain animeMain);

    boolean modify(AnimeMain animeMain);

    boolean delete(Integer id);

    AnimeMain selectMainById(Integer id);

    public PageInfo<AnimeMain> selectMainAll(int pageNum, int pageSize, AnimeMain animeMain);



}
