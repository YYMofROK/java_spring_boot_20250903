package com.sample_01.sample_01.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ZzimcarBooking {

//    private int szb01Pk; // szb_01_pk 컬럼
//    private String bookingNumber; // booking_number 컬럼 (예시)
//    private String customerName; // customer_name 컬럼 (예시)
//    private LocalDateTime creationDate; // creation_date 컬럼 (예시)

    private int szb_01_pk;
    private String szb_01_GDS_booking_pid;
    private String szb_01_GDS_booking_no;
    private String szb_01_GDS_booking_status_last;


    // ※ 여기에 실제 테이블의 컬럼에 맞춰 필드를 추가하세요.
}