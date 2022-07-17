package com.fubukianime.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fubukianime.domain.AnimeMain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author wyx
* @description 针对表【anime_main】的数据库操作Mapper
* @createDate 2022-07-14 15:07:06
* @Entity generator.domain.AnimeMain
*/
@Mapper
public interface AnimeMainDao extends BaseMapper<AnimeMain> {

    public AnimeMain selectMainById(Integer id);


    IPage<AnimeMain> selectMainAll(Page<AnimeMain> page);

    IPage<AnimeMain> selectMainByCondition(@Param("name") Page<AnimeMain> page);


}
