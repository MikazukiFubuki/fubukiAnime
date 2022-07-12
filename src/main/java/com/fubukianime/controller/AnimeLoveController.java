package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimeCreate;
import com.fubukianime.domain.AnimeLove;
import com.fubukianime.service.AnimeCreateService;
import com.fubukianime.service.AnimeLoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/animeLoves")
public class AnimeLoveController {

    @Autowired
    private AnimeLoveService animeLoveService;

    @GetMapping
    public R getAll(){
        return new R(true, animeLoveService.list());
    }

    @PostMapping
    public R save(@RequestBody AnimeLove animeLove) throws IOException {
        boolean flag = animeLoveService.save(animeLove);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    public R update(@RequestBody AnimeLove animeLove) throws IOException {
        boolean flag = animeLoveService.modify(animeLove);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(animeLoveService.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, animeLoveService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,AnimeLove animeLove){
        IPage<AnimeLove> page = animeLoveService.getPage(currentPage, pageSize,animeLove);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = animeLoveService.getPage((int)page.getPages(), pageSize,animeLove);
        }
        return new R(true, page);
    }
}
