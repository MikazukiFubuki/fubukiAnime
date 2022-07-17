package com.fubukianime.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fubukianime.dao.AnimeMainDao;
import com.fubukianime.dao.AnimeMainDao;
import com.fubukianime.domain.AnimeLove;
import com.fubukianime.domain.AnimeMain;
import com.fubukianime.domain.AnimeMain;
import com.fubukianime.service.AnimeMainService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

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

    @Override
    public PageInfo<AnimeMain> selectMainAll(int pageNum, int pageSize, AnimeMain animeMain) {
        LambdaQueryWrapper<AnimeMain> lqw = new LambdaQueryWrapper<AnimeMain>();
        lqw.like(Strings.isNotEmpty(animeMain.getName()), AnimeMain::getName, animeMain.getName());
        lqw.like(Strings.isNotEmpty(animeMain.getSource1()), AnimeMain::getSource1, animeMain.getSource1());
        lqw.like(Strings.isNotEmpty(animeMain.getSource2()), AnimeMain::getSource2, animeMain.getSource2());
        lqw.like(Strings.isNotEmpty(animeMain.getSource3()), AnimeMain::getSource3, animeMain.getSource3());
        lqw.like(Strings.isNotEmpty(animeMain.getLayoutId()), AnimeMain::getLayoutId, animeMain.getLayoutId());
        lqw.like(Strings.isNotEmpty(animeMain.getType1()), AnimeMain::getType1, animeMain.getType1());
        lqw.like(Strings.isNotEmpty(animeMain.getType2()), AnimeMain::getType2, animeMain.getType2());
        lqw.like(Strings.isNotEmpty(animeMain.getType3()), AnimeMain::getType3, animeMain.getType3());
        lqw.like(Strings.isNotEmpty(animeMain.getLove()), AnimeMain::getLove, animeMain.getLove());
        lqw.like(Strings.isNotEmpty(animeMain.getSexLimit()), AnimeMain::getSexLimit, animeMain.getSexLimit());
        lqw.like(Strings.isNotEmpty(animeMain.getCreate()), AnimeMain::getCreate, animeMain.getCreate());
        lqw.like(Strings.isNotEmpty(animeMain.getCompleteId()),AnimeMain::getCompleteId, animeMain.getCompleteId());
        lqw.like(Strings.isNotEmpty(animeMain.getBingeWatchingId()),AnimeMain::getBingeWatchingId, animeMain.getBingeWatchingId());
        lqw.like(Strings.isNotEmpty(animeMain.getReviewId()),AnimeMain::getReviewId, animeMain.getReviewId());
        lqw.like(Strings.isNotEmpty(animeMain.getLeaderGender()), AnimeMain::getLeaderGender, animeMain.getLeaderGender());
        lqw.like(Strings.isNotEmpty(animeMain.getFavoriteHeroine()), AnimeMain::getFavoriteHeroine, animeMain.getFavoriteHeroine());
        lqw.like(Strings.isNotEmpty(animeMain.getAnimationEnd()), AnimeMain::getAnimationEnd, animeMain.getAnimationEnd());
        lqw.like(Strings.isNotEmpty(animeMain.getOriginalEnd()), AnimeMain::getOriginalEnd, animeMain.getOriginalEnd());
        lqw.like(Strings.isNotEmpty(animeMain.getBroadcastYear()),AnimeMain::getBroadcastYear, animeMain.getBroadcastYear());
        lqw.like(Strings.isNotEmpty(animeMain.getBingeWatchingType()), AnimeMain::getBingeWatchingType, animeMain.getBingeWatchingType());
        lqw.like(Strings.isNotEmpty(animeMain.getBingeWatchingQuarter()), AnimeMain::getBingeWatchingQuarter, animeMain.getBingeWatchingQuarter());
        lqw.like(Strings.isNotEmpty(animeMain.getCompleteQuarter()), AnimeMain::getCompleteQuarter, animeMain.getCompleteQuarter());
        lqw.like(Strings.isNotEmpty(animeMain.getStatus()), AnimeMain::getStatus, animeMain.getStatus());
        PageHelper.startPage(pageNum, pageSize);
        List<AnimeMain> animeMainList = animeMainDao.selectMainAll();
        PageInfo<AnimeMain> page = new PageInfo<>(animeMainList);
        return page;
    }



}
