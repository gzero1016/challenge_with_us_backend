package com.dogtiger.challus.entity;

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
    private String nickname;
    private int challengeLikeCount;
<<<<<<< Updated upstream
=======
    private int challenger;
    private int isDeadline;
    private int isHidden;


    private ChallengeApplication challengeApplication;

    public ChallengeListRespDto toChallengeListDto() {
        return ChallengeListRespDto.builder()
                .challengeId(challengeId)
                .challengeName(challengeName)
                .categoryName(categoryName)
                .isApplicable(isApplicable)
                .userId(userId)
                .layout(challengeLayout)
                .introduction(introduction)
                .endDate(endDate.format(DateTimeFormatter.ISO_DATE))
                .name(name)
                .nickname(nickname)
                .startDate(startDate.format(DateTimeFormatter.ISO_DATE))
                .likeCount(challengeLikeCount)
                .isDeadline(isDeadline)
                .isHidden(isHidden)
                .build();
    }
>>>>>>> Stashed changes

    public GetChallengeRespDto toChallengeDto() {
        return GetChallengeRespDto.builder()
                .challengeId(challengeId)
                .userId(userId)
                .challengeName(challengeName)
                .layout(layout)
                .introduction(introduction)
                .isOpen(isOpen)
                .isApplicable(isApplicable)
                .startDate(startDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .endDate(endDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .categoryName(categoryName)
                .nickname(nickname)
                .name(name)
                .challengeLikeCount(challengeLikeCount)
                .build();
    }

}
