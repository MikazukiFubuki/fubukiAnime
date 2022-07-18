package com.fubukianime.dao;


import com.alibaba.druid.Constants;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fubukianime.domain.AnimeMain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* @author wyx
* @description 针对表【anime_main】的数据库操作Mapper
* @createDate 2022-07-14 15:07:06
* @Entity generator.domain.AnimeMain
*/
@Mapper
public interface AnimeMainDao extends BaseMapper<AnimeMain> {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public AnimeMain selectMainById(Integer id);

    /**
     * 查询全部并分页
     * @param page
     * @return
     */
    IPage<AnimeMain> selectMainAll(Page<AnimeMain> page);

    /**
     * 条件查询
     * @param animeMain
     * @return
     */
    List<AnimeMain> selectMainByCondition(AnimeMain animeMain);


}
