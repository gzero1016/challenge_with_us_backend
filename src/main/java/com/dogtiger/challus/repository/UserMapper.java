package com.dogtiger.challus.repository;

import com.dogtiger.challus.dto.GetAdminUserResDto;
import com.dogtiger.challus.entity.Feed;
import com.dogtiger.challus.entity.User;
import com.dogtiger.challus.entity.ChallengeApplication;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    public int updateMypageDetail(User user);
    public void deleteUser(int userId);
    public User findUserByEmail(String email);
    public User findUserByOauth2Id(String oauth2Id);
    public int saveIntro(User user);
    public int updateIntro(User user);
    public String getIntro(User user);
    public Integer saveUser(User user);
    public List<Map<String, Object>> getMembersCount();
    public List<Integer> getUserIdAll();
    public int checkpassword(String password);
    public List<User> getIsAdminUser();
    public int getProgress(int challengeId, int userId);
    public List<Feed> getChallengeFeeds (int challengeId, int userId);
}