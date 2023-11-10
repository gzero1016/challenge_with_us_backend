package com.dogtiger.challus.entity;

import com.dogtiger.challus.dto.ChallengeListRespDto;
import com.dogtiger.challus.dto.GetChallengeRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Challenge {
    private int challengeId;
    private int userId;
    private String challengeName;
    private int layout;
    private String introduction;
    private String isOpen;
    private String isApplicable;
    private LocalDate startDate;
    private LocalDate endDate;
    private String categoryName;
    private String name;
    private int challengeLikeCount;

    public ChallengeListRespDto toChallengeListDto() {
        return ChallengeListRespDto.builder()
                .challengeId(challengeId)
                .title(challengeName)
                .categoryname(categoryName)
                .startDate(startDate.format(DateTimeFormatter.ISO_DATE))
                .likeCount(challengeLikeCount)
                .build();
    }

    public GetChallengeRespDto toChallengeDto() {
        GetChallengeRespDto getChallengeRespDto = GetChallengeRespDto.builder()
                .challengeId(challengeId)
                .userId(userId)
                .challengeName(challengeName)
                .layout(layout)
                .introduction(introduction)
                .isOpen(isOpen)
                .isApplicable(isApplicable)
                .startDate(startDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .categoryName(categoryName)
                .name(name)
                .challengeLikeCount(challengeLikeCount)
                .build();

        if(endDate != null) {
            getChallengeRespDto.setEndDate(endDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }else {
            endDate = null;
        }
        return getChallengeRespDto;
    }

}
