package com.keroro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author wangpeng
 * @since 2024年01月23日 13:19
 */
@RestController
public class DateController {

    @GetMapping("/date")
    public Date out() {
        return new Date();
    }
}
