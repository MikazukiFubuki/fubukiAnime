package com.fubukianime.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fubukianime.dao.AnimeMainDao;
import com.fubukianime.dao.AnimeMainDao;
import com.fubukianime.domain.AnimeLayout;
import com.fubukianime.domain.AnimeLove;
import com.fubukianime.domain.AnimeMain;
import com.fubukianime.domain.AnimeMain;
import com.fubukianime.entity.PageResult;
import com.fubukianime.service.AnimeMainService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author wyx
* @description 针对表【anime_main】的数据库操作Service实现
* @createDate 2022-07-14 15:07:06
*/
@Service
public class AnimeMainServiceImpl extends ServiceImpl<AnimeMainDao, AnimeMain> implements AnimeMainService {

    @Autowired
    private AnimeMainDao animeMainDao;

    /**
     * 新增动画
     * @param animeMain
     * @return
     */
    @Override
    public boolean addAnime(AnimeMain animeMain) {
        animeMainDao.addAnime(animeMain);
        animeMainDao.addAnimeLayout();
        return true;
    }

    /**
     * 对已有动画新增形式
     * @param id
     */
    @Override
    public boolean addAnimeLayoutById(Integer id){
        animeMainDao.addAnimeLayoutById(id);
        return true;
    }

    /**
     * 开始追番，修改动画信息
     * @param animeMain
     */
    @Override
    public boolean startAnime(AnimeMain animeMain) {
        animeMainDao.startAnime(animeMain);
        return true;
    }

    /**
     * 增加动画来源
     * @param animeMain
     */
    @Override
    public boolean addSource(AnimeMain animeMain) {
        animeMainDao.addSource(animeMain);
        return true;
    }

    /**
     * 番剧补完，修改动画信息
     * @param animeMain
     */
    @Override
    public boolean endAnime(AnimeMain animeMain) {
        animeMainDao.endAnime(animeMain);
        return true;
    }

    /**
     * 对已追动画修改它的形式
     * @param animeLayout
     */
    @Override
    public boolean saveLayout(AnimeLayout animeLayout) {
        animeMainDao.saveLayout(animeLayout);
        return true;
    }

    /**
     * 番剧重温
     * @param id
     */
    @Override
    public boolean reviewAnime(Integer id) {
        animeMainDao.reviewAnime(id);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        return animeMainDao.deleteById(id) > 0;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public AnimeMain selectMainById(Integer id) {
        return animeMainDao.selectMainById(id);
    }

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public IPage<AnimeMain> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        animeMainDao.selectPage(page,null);
        return page;
    }

    /**
     * 全部分页查询
     * @param currentPage
     * @param pageSize
     * @param animeMain
     * @return
     */
    @Override
    public IPage<AnimeMain> getPage(int currentPage, int pageSize, AnimeMain animeMain) {
        Page<AnimeMain> page = new Page<>(currentPage,pageSize);
        animeMainDao.selectMainAll(page);
        return page;
    }

    /**
     * 条件查询
     * @param
     * @return
     */
    @Override
    public PageInfo<AnimeMain> selectByCondition(Integer pageNum, Integer pageSize, AnimeMain animeMain) {
        PageHelper.startPage(pageNum, pageSize);
        List<AnimeMain> animeMainList = animeMainDao.selectMainByCondition(animeMain);
        PageInfo<AnimeMain> animeMainPageInfo = new PageInfo<>(animeMainList, pageSize);
        return animeMainPageInfo;
    }

    /**
     * 查找要修改动画的全部形式
     * @param id
     * @return
     */
    @Override
    public List<AnimeLayout> selectAnimeLayoutByAnimeId(Integer id) {
        List<AnimeLayout> animeLayoutList = animeMainDao.selectAnimeLayoutByAnimeId(id);
        return animeLayoutList;
    }

    /**
     * 根据要修改动画的形式id查询
     * @param id
     * @return
     */
    @Override
    public AnimeLayout selectLayoutById(Integer id) {
        return animeMainDao.selectLayoutById(id);
    }

    /**
     * 修改追番、补番、重温序号
     * @param
     * @return
     */
    @Override
    public boolean updateCompleteId(AnimeMain animeMain) {
        Integer oldBCRId = animeMain.getCompleteId();
        Integer oldId = animeMain.getId();
        Integer modifyId = animeMain.getModifyId();
        Integer i;
        Integer j;

        //判断更改补完序号为增大还是减小
        //更改为增大补完序号
        if(oldBCRId < modifyId){
            //根据更改前补完序号的id将序号修改为0
            animeMain.setCompleteId(0);
            //animeMainDao.updateBCRId(animeMain);
            /**判断i值是否超过更改后补完序号
             * 未超过就修改更改之间数据的补完序号
             */
            //更改变量为更改前补完序号+1
            for(i = oldBCRId + 1 ; i<=modifyId; i++){
                //根据i值获取对应id
                animeMain.setCompleteId(i);
                j = animeMainDao.selectIdByBCRId(animeMain);
                //更改对应id
                animeMain.setId(j);
                //根据id将补完序号修改为i值-1
                animeMain.setCompleteId(i-1);
                animeMainDao.updateCompleteId(animeMain);
            }
        }else if(oldBCRId > modifyId){
            //更改为减小补完序号
            //根据更改前补完序号的id将序号修改为0
            animeMain.setCompleteId(0);
            //animeMainDao.updateBCRId(animeMain);
            /**判断i值是否小于更改后补完序号
             * 未小于就修改更改之间数据的补完序号
             */
            //更改变量为更改前补完序号-1
            for(i = oldBCRId - 1 ; i>=modifyId; i--){
                //根据i值获取对应id
                animeMain.setCompleteId(i);
                j = animeMainDao.selectIdByBCRId(animeMain);
                //更改对应id
                animeMain.setId(j);
                //根据id将补完序号修改为i值+1
                animeMain.setCompleteId(i+1);
                animeMainDao.updateCompleteId(animeMain);
            }
        }
        //根据更改前补完序号id将更改前补完序号修改更改后补完序号值
        animeMain.setId(oldId);
        animeMain.setCompleteId(modifyId);
        animeMainDao.updateCompleteId(animeMain);

        return true;
    }
}
