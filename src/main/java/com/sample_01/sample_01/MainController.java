package com.sample_01.sample_01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 웹 요청을 처리하고 적절한 뷰(HTML 페이지)를 반환하는 컨트롤러
 */
@Controller
public class MainController {

    /**
     * 루트 URL ("/") 요청을 처리합니다.
     * @return "main_dashboard_page" 문자열을 반환하여 templates/main_dashboard_page.html 파일을 렌더링하도록 지시합니다.
     */
    @GetMapping("/")
    public String root()
    {

        return "main_dashboard_page";
    }
}
