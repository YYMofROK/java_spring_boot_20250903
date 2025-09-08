package com.sample_01.sample_01.mapper.mariadb;

import com.sample_01.sample_01.dto.PageRequestDto;
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

    /**
     * 페이징 처리를 위해 모든 예약 건수를 조회합니다.
     * @return 총 예약 건수
     */
    int countBookings();

    /**
     * 페이징 처리된 예약 목록을 조회합니다.
     * @param pageRequestDto 페이징 파라미터 (offset, pageSize)
     * @return ZzimcarBooking 객체 리스트
     */
    List<ZzimcarBooking> findBookings(PageRequestDto pageRequestDto);
}
