package ua.lviv.lgs.money.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BalanceController {

    @GetMapping("/balance")
    public String getBalance() {
        return "balance";
    }
}
