package com.dogtiger.challus.repository;

import com.dogtiger.challus.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public int updateNickname(User user);
    public int updateProfileUrl(User user);
    public User findUserByEmail(String email);
    public User findUserByOauth2Id(String oauth2Id);
    public int saveIntro(User user);
    public int updateIntro(User user);
    public String getIntro(User user);
    public Integer saveUser(User user);
}