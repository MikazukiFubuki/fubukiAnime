package com.fubukianime.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fubukianime.domain.AnimeMain;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AnimeMainDaoTest {

    /*@Autowired
    private AnimeMainDao animeMainDao;


    @Test
    public void testGetAll(){
        List<AnimeMain> animeMainList = animeMainDao.selectList(null);
        System.out.println(animeMainList);
    }

    @Test
    public void testSelectMainAll(){
        List<AnimeMain> animeMainList = animeMainDao.selectMainAll();
        System.out.println(animeMainList);
    }/*

    @Test
    void testGetById() {
        AnimeMain animeMain = animeMainDao.selectById(1L);
        System.out.println(animeMain);
    }

    //分页查询
    @Test
    void testSelectPage(){
        //1 创建IPage分页对象,设置分页参数,1为当前页码，3为每页显示的记录数
        IPage<AnimeMain> page=new Page(2, 10);
        //2 执行分页查询
        animeMainDao.selectPage(page,null);
        //3 获取分页结果
        System.out.println("当前页码值："+page.getCurrent());
        System.out.println("每页显示数："+page.getSize());
        System.out.println("一共多少页："+page.getPages());
        System.out.println("一共多少条数据："+page.getTotal());
        System.out.println("数据："+page.getRecords());
    }*/


}
