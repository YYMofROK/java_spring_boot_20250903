package com.sample_01.sample_01.service;

import com.sample_01.sample_01.dto.PageRequestDto;
import com.sample_01.sample_01.dto.PageResponseDto;
import com.sample_01.sample_01.dto.ZzimcarBookingDto;
import com.sample_01.sample_01.mapper.mariadb.ZzimcarBookingMapper;
import com.sample_01.sample_01.model.ZzimcarBooking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ZzimcarBookingService {

    private final ZzimcarBookingMapper zzimcarBookingMapper;

    public PageResponseDto<ZzimcarBookingDto> getBookings(PageRequestDto pageRequestDto) {
        List<ZzimcarBooking> bookings = zzimcarBookingMapper.findBookings(pageRequestDto);
        List<ZzimcarBookingDto> dtoList = bookings.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        int totalBookings = zzimcarBookingMapper.countBookings();

        int pageBlockSize = 10; // 필요시 application.properties 등에서 관리할 수 있습니다.

        return new PageResponseDto<>(dtoList, totalBookings, pageRequestDto.getPage(), pageRequestDto.getPageSize(), pageBlockSize);
    }

    private ZzimcarBookingDto convertToDto(ZzimcarBooking entity) {
        ZzimcarBookingDto dto = new ZzimcarBookingDto();
        dto.setSzb_01_pk(entity.getSzb_01_pk());
        dto.setSzb_01_GDS_booking_pid(entity.getSzb_01_GDS_booking_pid());
        dto.setSzb_01_GDS_booking_no(entity.getSzb_01_GDS_booking_no());
        dto.setSzb_01_GDS_booking_status_last(entity.getSzb_01_GDS_booking_status_last());
        dto.setSzb_01_GDS_booking_reg_process(entity.getSzb_01_GDS_booking_reg_process());
        dto.setSzb_01_GDS_booking_reg_at(entity.getSzb_01_GDS_booking_reg_at());
        dto.setSzb_01_GDS_booking_cancel_process(entity.getSzb_01_GDS_booking_cancel_process());
        dto.setSzb_01_GDS_booking_cancel_at(entity.getSzb_01_GDS_booking_cancel_at());
        dto.setSzb_01_GDS_booking_retail_sales_method(entity.getSzb_01_GDS_booking_retail_sales_method());
        dto.setSzb_01_GDS_retailer_pid(entity.getSzb_01_GDS_retailer_pid());
        dto.setSzb_01_GDS_retailer_name(entity.getSzb_01_GDS_retailer_name());
        dto.setSzb_01_GDS_retailer_booking_no(entity.getSzb_01_GDS_retailer_booking_no());
        dto.setSzb_01_GDS_booking_pick_at(entity.getSzb_01_GDS_booking_pick_at());
        dto.setSzb_01_GDS_booking_drop_at(entity.getSzb_01_GDS_booking_drop_at());
        dto.setSzb_01_GDS_pre_paid_currency_pid(entity.getSzb_01_GDS_pre_paid_currency_pid());
        dto.setSzb_01_GDS_pre_paid_currency_code(entity.getSzb_01_GDS_pre_paid_currency_code());
        dto.setSzb_01_GDS_onsite_paid_currency_code(entity.getSzb_01_GDS_onsite_paid_currency_code());
        dto.setSzb_01_GDS_booking_payment_exchange_rate(entity.getSzb_01_GDS_booking_payment_exchange_rate());
        dto.setSzb_01_GDS_booking_car_nm_selling_price(entity.getSzb_01_GDS_booking_car_nm_selling_price());
        dto.setSzb_01_GDS_booking_insurance_nm_selling_price(entity.getSzb_01_GDS_booking_insurance_nm_selling_price());
        dto.setSzb_01_GDS_booking_price_delivery_pick(entity.getSzb_01_GDS_booking_price_delivery_pick());
        dto.setSzb_01_GDS_booking_price_delivery_drop(entity.getSzb_01_GDS_booking_price_delivery_drop());
        dto.setSzb_01_GDS_booking_price_total(entity.getSzb_01_GDS_booking_price_total());
        dto.setSzb_01_GDS_booking_price_deposit(entity.getSzb_01_GDS_booking_price_deposit());
        dto.setSzb_01_GDS_booking_price_onsite(entity.getSzb_01_GDS_booking_price_onsite());
        dto.setSzb_01_GDS_booking_price_cancel(entity.getSzb_01_GDS_booking_price_cancel());
        dto.setSzb_01_GDS_booking_car_model_name(entity.getSzb_01_GDS_booking_car_model_name());
        dto.setSzb_01_GDS_booking_car_supplier_name(entity.getSzb_01_GDS_booking_car_supplier_name());
        dto.setSzb_01_GDS_booking_car_supplier_nation(entity.getSzb_01_GDS_booking_car_supplier_nation());
        dto.setSzb_01_GDS_booking_car_supplier_area(entity.getSzb_01_GDS_booking_car_supplier_area());
        dto.setSzb_01_GDS_booker_name(entity.getSzb_01_GDS_booker_name());
        dto.setSzb_01_GDS_booker_first_name(entity.getSzb_01_GDS_booker_first_name());
        dto.setSzb_01_GDS_booker_mid_name(entity.getSzb_01_GDS_booker_mid_name());
        dto.setSzb_01_GDS_booker_last_name(entity.getSzb_01_GDS_booker_last_name());
        dto.setSzb_01_GDS_booker_email(entity.getSzb_01_GDS_booker_email());
        dto.setSzb_01_GDS_booker_country_code(entity.getSzb_01_GDS_booker_country_code());
        dto.setSzb_01_GDS_booker_contact(entity.getSzb_01_GDS_booker_contact());
        dto.setSzb_01_GDS_driver_name(entity.getSzb_01_GDS_driver_name());
        dto.setSzb_01_GDS_driver_first_name(entity.getSzb_01_GDS_driver_first_name());
        dto.setSzb_01_GDS_driver_mid_name(entity.getSzb_01_GDS_driver_mid_name());
        dto.setSzb_01_GDS_driver_last_name(entity.getSzb_01_GDS_driver_last_name());
        dto.setSzb_01_GDS_driver_country_code(entity.getSzb_01_GDS_driver_country_code());
        dto.setSzb_01_GDS_driver_contact(entity.getSzb_01_GDS_driver_contact());
        dto.setSzb_01_GDS_driver_email(entity.getSzb_01_GDS_driver_email());
        dto.setSzb_01_GDS_driver_birth(entity.getSzb_01_GDS_driver_birth());
        dto.setSzb_01_GDS_paid_amount(entity.getSzb_01_GDS_paid_amount());
        dto.setSzb_01_GDS_unpaid_amount(entity.getSzb_01_GDS_unpaid_amount());
        dto.setSzb_01_GDS_data_source_json(entity.getSzb_01_GDS_data_source_json());
        return dto;
    }
}
