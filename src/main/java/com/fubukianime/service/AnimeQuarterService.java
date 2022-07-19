package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeQuarter;


public interface AnimeQuarterService extends IService<AnimeQuarter> {


    boolean save(AnimeQuarter animeQuarter);

    boolean modify(AnimeQuarter animeQuarter);

    boolean delete(Integer id);

    IPage<AnimeQuarter> getPage(int currentPage, int pageSize);

    IPage<AnimeQuarter> getPage(int currentPage, int pageSize, AnimeQuarter animeQuarter);


}
