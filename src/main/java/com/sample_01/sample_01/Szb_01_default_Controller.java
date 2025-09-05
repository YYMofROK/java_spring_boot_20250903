package com.sample_01.sample_01;

import com.sample_01.sample_01.mapper.mariadb.ZzimcarBookingMapper;
import com.sample_01.sample_01.model.ZzimcarBooking;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String root(@RequestParam(value = "page", defaultValue = "1") int page, Model model)
    {
        // 페이징 설정
        int pageSize = 30; // 한 페이지에 보여줄 게시물 수
        int pageBlockSize = 10; // 한 번에 보여줄 페이지 번호 개수

        // DB에서 데이터 조회
        int offset = (page - 1) * pageSize;
        Map<String, Object> params = new HashMap<>();
        params.put("offset", offset);
        params.put("pageSize", pageSize);
        List<ZzimcarBooking> bookings = zzimcarBookingMapper.findBookings(params);

        int totalBookings = zzimcarBookingMapper.countBookings();
        int totalPages = (int) Math.ceil((double) totalBookings / pageSize);

        // 페이지 블록 계산
        int startPage = ((page - 1) / pageBlockSize) * pageBlockSize + 1;
        int endPage = startPage + pageBlockSize - 1;
        if (endPage > totalPages) {
            endPage = totalPages;
        }

        // 모델에 데이터 추가
        model.addAttribute("bookings", bookings);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "szb_01_list";
    }
}
