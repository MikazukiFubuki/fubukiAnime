package com.fubukianime.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fubukianime.domain.AnimeMain;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AnimeMainDaoTest {

    @Autowired
    private AnimeMainDao animeMainDao;


    /*@Test
    public void testGetAll(){
        List<AnimeMain> animeMainList = animeMainDao.selectList(null);
        System.out.println(animeMainList);
    }*/

    @Test
    public void testSelectByCondition() throws IOException {
        /*//接收参数
        String name = "你";
        //方式二 ：接口方法参数是 实体类对象 方式调用的方法
        //封装对象
        AnimeMain animeMain = new AnimeMain();
        animeMain.setName(name);
        LambdaQueryWrapper<AnimeMain> lqw = new LambdaQueryWrapper<AnimeMain>();
        lqw.like(Strings.isNotEmpty(animeMain.getName()), AnimeMain::getName, animeMain.getName());
        //animeMain.setName(name);*/



        //4. 执行方法
        //方式三 ：接口方法参数是 map集合对象 方式调用的方法
        Page<AnimeMain> page = new Page<>(1,10);
        IPage<AnimeMain> ipage = animeMainDao.selectMainByCondition(page);
        System.out.println(ipage);

    }

    /*@Test
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
