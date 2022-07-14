package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimeQuarter;
import com.fubukianime.service.AnimeQuarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/animeQuarters")
public class AnimeQuarterController {

    @Autowired
    private AnimeQuarterService animeQuarterService;

    @GetMapping
    public R getAll(){
        return new R(true, animeQuarterService.list());
    }

    @PostMapping
    public R save(@RequestBody AnimeQuarter animeQuarter) throws IOException {
        boolean flag = animeQuarterService.save(animeQuarter);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    public R update(@RequestBody AnimeQuarter animeQuarter) throws IOException {
        boolean flag = animeQuarterService.modify(animeQuarter);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(animeQuarterService.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, animeQuarterService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,AnimeQuarter animeQuarter){
        IPage<AnimeQuarter> page = animeQuarterService.getPage(currentPage, pageSize,animeQuarter);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = animeQuarterService.getPage((int)page.getPages(), pageSize,animeQuarter);
        }
        return new R(true, page);
    }
}
