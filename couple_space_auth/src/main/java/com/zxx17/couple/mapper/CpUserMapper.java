package com.zxx17.couple.mapper;

import com.zxx17.couple.domain.CpUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Zhuo
* @description 针对表【cp_user(用户表)】的数据库操作Mapper
* @createDate 2024-10-27 18:33:23
* @Entity com.zxx17.couple.domain.CpUser
*/
@Mapper
public interface CpUserMapper extends BaseMapper<CpUser> {

}




