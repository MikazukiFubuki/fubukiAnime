package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimeStatus;
import com.fubukianime.service.AnimeStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/animeStatuss")
public class AnimeStatusController {

    @Autowired
    private AnimeStatusService animeStatusService;

    @GetMapping
    public R getAll(){
        return new R(true, animeStatusService.list());
    }

    @PostMapping
    public R save(@RequestBody AnimeStatus animeStatus) throws IOException {
        boolean flag = animeStatusService.save(animeStatus);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    public R update(@RequestBody AnimeStatus animeStatus) throws IOException {
        boolean flag = animeStatusService.modify(animeStatus);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(animeStatusService.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, animeStatusService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,AnimeStatus animeStatus){
        IPage<AnimeStatus> page = animeStatusService.getPage(currentPage, pageSize,animeStatus);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = animeStatusService.getPage((int)page.getPages(), pageSize,animeStatus);
        }
        return new R(true, page);
    }
}
