package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimeSource;
import com.fubukianime.service.AnimeSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/animeSources")
public class AnimeSourceController {

    @Autowired
    private AnimeSourceService animeSourceService;

    @GetMapping
    public R getAll(){
        return new R(true, animeSourceService.list());
    }

    @PostMapping
    public R save(@RequestBody AnimeSource animeSource) throws IOException {
        boolean flag = animeSourceService.save(animeSource);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    public R update(@RequestBody AnimeSource animeSource) throws IOException {
        boolean flag = animeSourceService.modify(animeSource);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(animeSourceService.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, animeSourceService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,AnimeSource animeSource){
        IPage<AnimeSource> page = animeSourceService.getPage(currentPage, pageSize,animeSource);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = animeSourceService.getPage((int)page.getPages(), pageSize,animeSource);
        }
        return new R(true, page);
    }
}
