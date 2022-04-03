package com.codegym.controller;

import com.codegym.MedicalDeclaration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.nio.charset.Charset;

@Controller
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
public class HomeController {
    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }
    @GetMapping()
    public ModelAndView create(@ModelAttribute MedicalDeclaration medicalDeclaration) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("medicalDeclaration", new MedicalDeclaration());
        modelAndView.addObject("birthday", new String[]{ "1985", "1986", "1987", "1989", "1990",
                "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002"});
        modelAndView.addObject("gender", new String[]{ "Nam", "Nữ", "Other"});
        modelAndView.addObject("nationality", new String[]{ "Việt Nam", "Mỹ", "Anh", "Trung Quốc"
                , "Nhật Bản", "Hàn Quốc", "Canada"});
        modelAndView.addObject("passport1", new String[]{ "CMND", "Passport"});
        modelAndView.addObject("move", new String[]{"Máy Bay ", "Tàu Thuyền ", "Ô-tô ", "Other (Ghi rõ):"});
        modelAndView.addObject("departureDay", new String[]{ "01", "02", "03", "04", "05", "06", "07"
                , "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
                "25", "26", "27", "28"
                , "29", "30", "31"});
        modelAndView.addObject("departureMonth", new String[]{ "January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October", "November", "December"});
        modelAndView.addObject("departureYear", new String[]{ "2019", "2020", "2021", "2022", "2023", "2024"});
        modelAndView.addObject("endDate", new String[]{ "01", "02", "03", "04", "05", "06", "07"
                , "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
                "25", "26", "27", "28"
                , "29", "30", "31"});
        modelAndView.addObject("endMonth", new String[]{ "January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October", "November", "December"});
        modelAndView.addObject("endYear", new String[]{ "2019", "2020", "2021", "2022", "2023", "2024"});
        modelAndView.addObject("city", new String[]{"Đà Nẵng"});
        modelAndView.addObject("district", new String[]{ "Quận Liên Chiểu", "Quận Thanh Khê",
                "Quận Hải Châu", "Quận Sơn Trà", "Quận Ngũ Hành Sơn", "Quận Cẩm Lệ", "Huyện Hoà Vang"});
        modelAndView.addObject("ward", new String[]{ "Phường Hoà Hiệp Bắc", "Phường Hoà Hiệp Nam",
                "Phường Hoà Khánh Bắc", "Phường Hoà Khánh Nam", "Phường Hoà Minh", "Phường Tam Thuận",
                "Phường Thanh Khê Tây", "Phường Thanh Khê Đông", "Phường Xuân Hà", "Phường Tân Chính",
                "Phường Chính Gián", "Phường Vĩnh Trung", "Phường Thạc Gián", "Phường An Khê", "Phường Hoà Khê"});
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView display(@ModelAttribute MedicalDeclaration medicalDeclaration) {
        ModelAndView modelAndView = new ModelAndView("display");
        modelAndView.addObject("medicalDeclaration", medicalDeclaration);
        return modelAndView;
    }
}
