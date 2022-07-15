package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimeLove;
import com.fubukianime.domain.AnimeMain;
import com.fubukianime.service.AnimeMainService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animeMains")
public class AnimeMainController {

    @Autowired
    private AnimeMainService animeMainService;

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, animeMainService.selectMainById(id));
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R selectMainAll(@PathVariable Integer currentPage,@PathVariable Integer pageSize, AnimeMain animeMain){
        PageInfo<AnimeMain> pageInfo = animeMainService.selectMainAll(currentPage, pageSize, animeMain);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        /*if( currentPage > page.getPages()){
            page = animeMainService.getPage((int)page.getPages(), pageSize,animeMain);
        }*/
        return new R(true, pageInfo);
    }



}
