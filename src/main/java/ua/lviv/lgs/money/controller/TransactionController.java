package ua.lviv.lgs.money.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ua.lviv.lgs.money.domain.Transaction;
import ua.lviv.lgs.money.domain.enumeration.Type;
import ua.lviv.lgs.money.service.CategoryService;
import ua.lviv.lgs.money.service.TransactionService;
import ua.lviv.lgs.money.service.UserService;
import ua.lviv.lgs.money.service.dto.TransactionDTO;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TransactionController {

    private final UserService userService;

    private final TransactionService transactionService;

    private final CategoryService categoryService;

    @GetMapping("/transactions/income")
    public String getIncomePage(Model model, Pageable pageable) {
        Page<Transaction> transactionPage = transactionService.findByAccountId(userService.findUserCurrentAccountId(),
                Type.INCOME, pageable);
        model.addAttribute("incomePage", transactionPage);
        return "income";
    }

    @GetMapping("/transactions/expense")
    public String getExpensePage(Model model, Pageable pageable) {
        Page<Transaction> transactionPage = transactionService.findByAccountId(userService.findUserCurrentAccountId(),
                Type.EXPENSE, pageable);
        model.addAttribute("expensePage", transactionPage);
        return "expense";
    }

    @PostMapping("/transactions")
    public TransactionDTO createTransaction(@RequestBody TransactionDTO transaction) {
        log.info("create transacition");
        return transactionService.create(userService.findCurrentUserId(), transaction);
    }

    @GetMapping("/transactions/income/create")
    public String createTransaction(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "create-income";
    }
}
