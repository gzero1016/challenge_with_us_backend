package com.dogtiger.challus.scheduler;

import com.dogtiger.challus.repository.ChallengeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;

@RequiredArgsConstructor
@Component
public class ChallengeScheduledTask {
    private final ChallengeMapper challengeMapper;

    @Scheduled(cron = "0 0 0 * * *")
    public void processChallengeDeadLine() {
        challengeMapper.processDeadLine();
    }

}