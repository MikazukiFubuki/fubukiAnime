package com.fubukianime.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fubukianime.dao.AnimeMainDao;
import com.fubukianime.dao.AnimeMainDao;
import com.fubukianime.domain.AnimeLove;
import com.fubukianime.domain.AnimeMain;
import com.fubukianime.domain.AnimeMain;
import com.fubukianime.entity.PageResult;
import com.fubukianime.service.AnimeMainService;
import com.github.pagehelper.PageHelper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author wyx
* @description 针对表【anime_main】的数据库操作Service实现
* @createDate 2022-07-14 15:07:06
*/
@Service
public class AnimeMainServiceImpl extends ServiceImpl<AnimeMainDao, AnimeMain> implements AnimeMainService {

    @Autowired
    private AnimeMainDao animeMainDao;

    @Override
    public boolean saveMain(AnimeMain animeMain) {
        return animeMainDao.insert(animeMain) > 0;
    }

    @Override
    public boolean modify(AnimeMain animeMain) {
        return animeMainDao.updateById(animeMain) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return animeMainDao.deleteById(id) > 0;
    }

    @Override
    public AnimeMain selectMainById(Integer id) {
        return animeMainDao.selectMainById(id);
    }

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public IPage<AnimeMain> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        animeMainDao.selectPage(page,null);
        return page;
    }

    /**
     * 全部分页查询
     * @param currentPage
     * @param pageSize
     * @param animeMain
     * @return
     */
    @Override
    public IPage<AnimeMain> getPage(int currentPage, int pageSize, AnimeMain animeMain) {
        Page<AnimeMain> page = new Page<>(currentPage,pageSize);
        animeMainDao.selectMainAll(page);
        return page;
    }
}
