package com.dogtiger.challus.repository;

import com.dogtiger.challus.entity.Letter;
import com.dogtiger.challus.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LetterMapper {
    public List<Letter> findLettersByUserId(int userId);
    public Letter findLetterByLetterId(int letterId);
    public int getLettersCountByUserId(int userId);
    public int updateLetter(Letter letter);
    public int challengeAtmosphereLetter(Letter letter);
}