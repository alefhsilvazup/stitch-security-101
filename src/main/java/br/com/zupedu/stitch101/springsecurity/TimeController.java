package br.com.zupedu.stitch101.springsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class TimeController {

    @GetMapping("/time")
    public String time() {
        return "time";
    }

}
