package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimeLayoutType;
import com.fubukianime.service.AnimeLayoutTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/animeLayoutTypes")
public class AnimeLayoutTypeController {

    @Autowired
    private AnimeLayoutTypeService animeLayoutTypeService;

    @GetMapping
    public R getAll(){
        return new R(true, animeLayoutTypeService.list());
    }

    @PostMapping
    public R save(@RequestBody AnimeLayoutType animeLayoutType) throws IOException {
        boolean flag = animeLayoutTypeService.save(animeLayoutType);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    public R update(@RequestBody AnimeLayoutType animeLayoutType) throws IOException {
        boolean flag = animeLayoutTypeService.modify(animeLayoutType);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(animeLayoutTypeService.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, animeLayoutTypeService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,AnimeLayoutType animeLayoutType){
        IPage<AnimeLayoutType> page = animeLayoutTypeService.getPage(currentPage, pageSize,animeLayoutType);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = animeLayoutTypeService.getPage((int)page.getPages(), pageSize,animeLayoutType);
        }
        return new R(true, page);
    }
}
