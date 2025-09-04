package com.sample_01.sample_01.mapper.mariadb;

import com.sample_01.sample_01.model.ZzimcarBooking;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ZzimcarBookingMapper {
    /**
     * settlement_01_zzimcar_booking 테이블에서 최신 10개의 데이터를 조회합니다.
     * @return ZzimcarBooking 객체 리스트
     */
    List<ZzimcarBooking> findLatestBookings();
}
