package com.fubukianime.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fubukianime.domain.AnimeMain;
import org.apache.ibatis.annotations.Mapper;

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

    public List<AnimeMain> selectMainAll();


}
