package com.dlskawo0409.demo.houseinfo.domain;


import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface HouseInfoRepository extends JpaRepository<HouseInfo, Long> {

    List<HouseInfo> findByPreDongCodeAndPostDongCode(String preDongCode, String postDongCode);

}
