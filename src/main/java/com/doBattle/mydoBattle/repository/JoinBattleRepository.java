package com.doBattle.mydoBattle.repository;

import com.doBattle.mydoBattle.entity.JoinBattle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JoinBattleRepository extends JpaRepository<JoinBattle, Long> {
    List<JoinBattle> findByMemberId(Long memberId);

    //나를 제외한 배틀 참여자 리스트 찾기
    @Query(value = "SELECT * FROM join_battle WHERE battle_code = :battleCode AND member_id != :memberId", nativeQuery = true)
    List<JoinBattle> findByBattleCodeWithoutCurrentMember(Long battleCode, Long memberId);
}
