package com.sample_01.sample_01;

import com.sample_01.sample_01.mapper.mariadb.ZzimcarBookingMapper;
import com.sample_01.sample_01.model.ZzimcarBooking;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 웹 요청을 처리하고 적절한 뷰(HTML 페이지)를 반환하는 컨트롤러
 */
@Controller
public class Szb_01_default_Controller {

    private final ZzimcarBookingMapper zzimcarBookingMapper;

    public Szb_01_default_Controller(ZzimcarBookingMapper zzimcarBookingMapper) {
        this.zzimcarBookingMapper = zzimcarBookingMapper;
    }

    /**
     * 루트 URL ("/") 요청을 처리합니다.
     * @return "main_dashboard" 문자열을 반환하여 templates/main_dashboard.html 파일을 렌더링하도록 지시합니다.
     */
    @GetMapping("/szb_01_list")
    public String root(Model model)
    {
        List<ZzimcarBooking> bookings = zzimcarBookingMapper.findLatestBookings();
        model.addAttribute("bookings", bookings);
        return "szb_01_default";
    }
}
