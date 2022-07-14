package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.AnimeQuarterDao;
import com.fubukianime.domain.AnimeQuarter;
import com.fubukianime.service.AnimeQuarterService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimeQuarterServiceImpl extends ServiceImpl<AnimeQuarterDao, AnimeQuarter> implements AnimeQuarterService {

    @Autowired
    private AnimeQuarterDao animeQuarterDao;

    @Override
    public boolean saveQuarter(AnimeQuarter animeQuarter) {
        return animeQuarterDao.insert(animeQuarter) > 0;
    }

    @Override
    public boolean modify(AnimeQuarter animeQuarter) {
        return animeQuarterDao.updateById(animeQuarter) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return animeQuarterDao.deleteById(id) > 0;
    }

    @Override
    public IPage<AnimeQuarter> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        animeQuarterDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<AnimeQuarter> getPage(int currentPage, int pageSize, AnimeQuarter animeQuarter) {
        LambdaQueryWrapper<AnimeQuarter> lqw = new LambdaQueryWrapper<AnimeQuarter>();
        lqw.like(Strings.isNotEmpty(animeQuarter.getQuarter()), AnimeQuarter::getQuarter, animeQuarter.getQuarter());
        IPage page = new Page(currentPage,pageSize);
        animeQuarterDao.selectPage(page,lqw);
        return page;
    }


}
