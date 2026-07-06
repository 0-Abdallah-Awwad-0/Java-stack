package com.axsos.springboot.routes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// the main route
    @RestController
    @RequestMapping("/daikichi")
public class DaikichiController {
//        welcome route with aa return value
        @RequestMapping("")
        public String welcome(){
            return "welcome";
        }
//        today route after writing the daikichi route
        @RequestMapping("/today")
        public String today(){
            return "Today you will find luck in all your endeavors";
        }
    //        tomorrow route after writing the daikichi route

    @RequestMapping("/tomorrow")
        public String tomorrow(){
            return "Tomorrow, an opportunity will arise , so be sure to be open to new ides!";
        }
    }
