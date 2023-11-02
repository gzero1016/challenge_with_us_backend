package com.dogtiger.challus.repository;

import com.dogtiger.challus.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public int updatePassword(User user);
    public int updateNickname(User user);
    public User findUserByOauth2Id(String oauth2Id);
}
