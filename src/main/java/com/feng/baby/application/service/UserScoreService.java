package com.feng.baby.application.service;

import com.feng.baby.model.ScoreSource;
import com.feng.baby.model.SignRule;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprout.jooq.generate.tables.records.UserScoreRecordRecord;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static sprout.jooq.generate.Tables.USER_ACCOUNT;
import static sprout.jooq.generate.Tables.USER_SCORE_RECORD;

@Slf4j
@Service
public class UserScoreService {

    private final DSLContext jooq;

    @Autowired
    UserScoreService(DSLContext jooq) {
        this.jooq = jooq;
    }


    public Map<String, Object> todaySigned(String username) {
        Map<String, Object> data;

        Optional<UserScoreRecordRecord> record = jooq.selectFrom(USER_SCORE_RECORD)
                .where(USER_SCORE_RECORD.USERNAME.eq(username))
                .orderBy(USER_SCORE_RECORD.LAST_SIGN_DAY.desc())
                .stream().findFirst();

        if (record.isPresent()) {
            UserScoreRecordRecord score = record.get();
            if (LocalDate.now().toString().equals(score.getLastSignDay())) {
                data = ImmutableMap.of("isSigned", true, "score", score.getSourceAfter(), "continueDays", score.getContinuedDays());
            } else if (LocalDate.now().minusDays(1).toString().equals(score.getLastSignDay())) {
                data = ImmutableMap.of("isSigned", false, "score", score.getSourceAfter(), "continueDays", score.getContinuedDays());
            } else {
                data = ImmutableMap.of("isSigned", false, "score", score.getSourceAfter(), "continueDays", 0);
            }
        } else {
            data = ImmutableMap.of("isSigned", false, "score", 0, "continueDays", 0);
        }

        return data;
    }

    public Map<String, Object> sign(String username) {
        //检测今天是否已签到，签到过的话返回
        Optional<UserScoreRecordRecord> userScoreRecordRecord = jooq.selectFrom(USER_SCORE_RECORD)
                .where(USER_SCORE_RECORD.USERNAME.eq(username))
                .and(USER_SCORE_RECORD.LAST_SIGN_DAY.eq(LocalDate.now().toString()))
                .fetchOptionalInto(USER_SCORE_RECORD);
        if (userScoreRecordRecord.isPresent())
            return ImmutableMap.of("isSigned", true, "score", userScoreRecordRecord.get().getSourceAfter(), "continueDays",
                    userScoreRecordRecord.get().getContinuedDays());


        Optional<UserScoreRecordRecord> lastSignDay = jooq.selectFrom(USER_SCORE_RECORD)
                .where(USER_SCORE_RECORD.USERNAME.eq(username))
                .orderBy(USER_SCORE_RECORD.LAST_SIGN_DAY.desc())
                .fetchStream().findFirst();

        //查看签到记录表，检测这是第几天签到,获取签到规则
        Integer continuedDays;
        Integer sourceBefore;
        Integer todayScore;
        if (lastSignDay.isPresent()) {
            if(lastSignDay.get().getLastSignDay().equals(LocalDate.now().minusDays(1).toString())){//最后一次签到是昨天
                continuedDays = lastSignDay.get().getContinuedDays();
                continuedDays = continuedDays >= 7 ? 7 : continuedDays + 1;
                sourceBefore = lastSignDay.get().getSourceAfter();
                todayScore = SignRule.data.get(continuedDays);
            }else {//最后一次签到不是昨天
                continuedDays = 1;
                sourceBefore = lastSignDay.get().getSourceAfter();
                todayScore = SignRule.data.get(SignRule.FIRSTDAY);
            }
        } else {
            continuedDays = 1;
            sourceBefore = 0;
            todayScore = SignRule.data.get(SignRule.FIRSTDAY);
        }

        jooq.insertInto(USER_SCORE_RECORD)
                .set(USER_SCORE_RECORD.LAST_SIGN_DAY, LocalDate.now().toString())
                .set(USER_SCORE_RECORD.SOURCE_AFTER, sourceBefore + todayScore)
                .set(USER_SCORE_RECORD.SCORE_TO_DAY, todayScore)
                .set(USER_SCORE_RECORD.USERNAME, username)
                .set(USER_SCORE_RECORD.USER_SCORE_RECORD_ID, UUID.randomUUID().toString())
                .set(USER_SCORE_RECORD.CONTINUED_DAYS, continuedDays)
                .set(USER_SCORE_RECORD.SOURCE, ScoreSource.SING.name())
                .execute();

        //向积分表中添加数据
        jooq.insertInto(USER_ACCOUNT)
                .set(USER_ACCOUNT.USERNAME, username)
                .set(USER_ACCOUNT.SCORE, sourceBefore + todayScore)
                .onDuplicateKeyUpdate()
                .set(USER_ACCOUNT.SCORE, sourceBefore + todayScore)
                .execute();

        return ImmutableMap.of("isSigned", true, "score", sourceBefore + todayScore, "continueDays", continuedDays);
    }
}
