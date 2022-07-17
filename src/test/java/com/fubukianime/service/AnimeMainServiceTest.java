package com.fubukianime.service;

import com.fubukianime.dao.AnimeMainDao;
import com.fubukianime.domain.AnimeMain;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AnimeMainServiceTest {
    /*@Autowired
    private AnimeMainService animeMainService;
    @Autowired
    private AnimeMain animeMain;
*//*
    @Test
    void testFindAll() {
        List<AnimeMain> list = animeMainService.list();
        System.out.println(list);
    }*//*

    @Test
    void testSelectMainAll() {
        List<AnimeMain> list = animeMainService.selectMainAll(1,10,animeMain);
        System.out.println(list);
    }

    @Test
    void testFindById(){
        AnimeMain animeMain = animeMainService.getById(1L);
        System.out.println(animeMain);
    }

    @Test
    void testSelectMainById(){
        AnimeMain animeMain = animeMainService.selectMainById(1);
        System.out.println(animeMain);
    }*/


}
