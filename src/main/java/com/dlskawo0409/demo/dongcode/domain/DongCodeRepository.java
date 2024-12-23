package com.dlskawo0409.demo.dongcode.domain;

import com.dlskawo0409.demo.dongcode.dto.response.SidoGugunDongResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DongCodeRepository extends JpaRepository<DongCode, String> {
    @Query("SELECT DISTINCT d.sidoName FROM DongCode d ORDER BY d.sidoName")
    List<String> findSido();

    @Query("SELECT DISTINCT d.gugunName FROM DongCode d WHERE d.sidoName = :sido ORDER BY d.gugunName")
    List<String> findGugunBySido(@Param("sido") String sido);

    @Query("SELECT DISTINCT d.dongName FROM DongCode d WHERE d.sidoName = :sido AND d.gugunName = :gugun ORDER BY d.dongName")
    List<String> findDongByGugun(@Param("sido") String sido, @Param("gugun") String gugun);

    @Query("SELECT d.DongCode FROM DongCode d WHERE d.sidoName = :sido AND d.gugunName = :gugun AND d.dongName = :dong")
    String findDongCodeByDong(@Param("sido") String sido, @Param("gugun") String gugun, @Param("dong") String dong);

    @Query("SELECT new com.dlskawo0409.demo.dongcode.dto.response.SidoGugunDongResponse(d.sidoName, d.gugunName, d.dongName) " +
            "FROM DongCode d WHERE d.DongCode = :dongCode")
    SidoGugunDongResponse findSidoGugunDongByDongCode(@Param("dongCode") String dongCode);

}