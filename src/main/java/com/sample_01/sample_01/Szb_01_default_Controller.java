package com.sample_01.sample_01;

import com.sample_01.sample_01.dto.PageRequestDto;
import com.sample_01.sample_01.dto.PageResponseDto;
import com.sample_01.sample_01.dto.ZzimcarBookingDto;
import com.sample_01.sample_01.service.ZzimcarBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 웹 요청을 처리하고 적절한 뷰(HTML 페이지)를 반환하는 컨트롤러
 */
@Controller
@RequiredArgsConstructor
public class Szb_01_default_Controller {

    private final ZzimcarBookingService zzimcarBookingService;

    /**
     * 루트 URL ("/") 요청을 처리합니다.
     * @return "main_dashboard" 문자열을 반환하여 templates/main_dashboard.html 파일을 렌더링하도록 지시합니다.
     */
    @GetMapping("/szb_01_list")
    public String root(@RequestParam(value = "page", defaultValue = "1") int page, Model model)
    {
        // 페이징 설정
        int pageSize = 30; // 한 페이지에 보여줄 게시물 수
        PageRequestDto pageRequestDto = new PageRequestDto(page, pageSize);

        // 서비스에서 데이터 조회
        PageResponseDto<ZzimcarBookingDto> pageResponseDto = zzimcarBookingService.getBookings(pageRequestDto);

        // 모델에 데이터 추가
        model.addAttribute("bookings", pageResponseDto.getDtoList());
        model.addAttribute("currentPage", pageResponseDto.getCurrentPage());
        model.addAttribute("totalPages", pageResponseDto.getTotalPages());
        model.addAttribute("startPage", pageResponseDto.getStartPage());
        model.addAttribute("endPage", pageResponseDto.getEndPage());

        return "szb_01_list";
    }
}
