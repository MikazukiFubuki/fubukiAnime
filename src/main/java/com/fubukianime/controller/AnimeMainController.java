package com.fubukianime.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.dao.AnimeMainDao;
import com.fubukianime.domain.AnimeLayout;
import com.fubukianime.domain.AnimeLove;
import com.fubukianime.domain.AnimeMain;
import com.fubukianime.service.AnimeMainService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/animeMains")
public class AnimeMainController {

    @Autowired
    private AnimeMainService animeMainService;

    /**
     * 新增动画
     * @param animeMain
     * @return
     * @throws IOException
     */
    @PostMapping
    public R save(@RequestBody AnimeMain animeMain) throws IOException{
        boolean flag =  animeMainService.save(animeMain);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    /**
     * 查询全部
     * @return
     */
    @GetMapping
    public R getAll(){
        return new R(true, animeMainService.list());
    }

    /**
     * 根据动画id新增形式
     * @param id
     * @return
     */
    @GetMapping("/addAnimeLayoutById/{id}")
    public R saveLayout(@PathVariable Integer id){
        return new R(true, animeMainService.addAnimeLayoutById(id));
    }

    /**
     * 根据动画id新增形式
     * @param id
     * @return
     */
    @GetMapping("/reviewAnime/{id}")
    public R reviewAnime(@PathVariable Integer id){
        return new R(true, animeMainService.reviewAnime(id));
    }

    /**
     * 根据动画id新增形式
     * @param id
     * @return
     */
    @GetMapping("/selectAnimeLayoutById/{id}")
    public R selectAnimeLayoutById(@PathVariable Integer id){
        List<AnimeLayout> list = animeMainService.selectAnimeLayoutById(id);
        return new R(true, list);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, animeMainService.selectMainById(id));
    }

    /**
     * 分页查询全部
     * @param currentPage
     * @param pageSize
     * @param animeMain
     * @return
     */
    @GetMapping("/{currentPage}/{pageSize}")
    public R selectMainAll(@PathVariable Integer currentPage,@PathVariable Integer pageSize, AnimeMain animeMain){
        IPage<AnimeMain> page = animeMainService.getPage(currentPage, pageSize,animeMain);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = animeMainService.getPage((int)page.getPages(), pageSize,animeMain);
        }
        return new R(true, page);
    }

    /**
     * 条件查询
     * @param animeMain
     * @return
     */
    @GetMapping("/byCondition/{currentPage}/{pageSize}")
    public R selectByCondition(@PathVariable Integer currentPage,@PathVariable Integer pageSize, AnimeMain animeMain){
        PageInfo<AnimeMain> pageInfo = animeMainService.selectByCondition(currentPage, pageSize,animeMain);
        return new R(true, pageInfo);
    }

    @PutMapping("/startAnime")
    public R startAnime(@RequestBody AnimeMain animeMain) throws IOException {
        boolean flag = animeMainService.startAnime(animeMain);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @PutMapping("/addSource")
    public R addSource(@RequestBody AnimeMain animeMain) throws IOException {
        boolean flag = animeMainService.addSource(animeMain);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @PutMapping("/endAnime")
    public R endAnime(@RequestBody AnimeMain animeMain) throws IOException {
        boolean flag = animeMainService.endAnime(animeMain);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @PutMapping("/saveLayout")
    public R saveLayout(@RequestBody AnimeLayout animeLayout) throws IOException {
        boolean flag = animeMainService.saveLayout(animeLayout);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

}
