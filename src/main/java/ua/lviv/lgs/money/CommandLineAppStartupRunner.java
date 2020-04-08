package ua.lviv.lgs.money;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.lviv.lgs.money.domain.*;
import ua.lviv.lgs.money.domain.enumeration.Type;
import ua.lviv.lgs.money.repository.CurrencyRepository;
import ua.lviv.lgs.money.service.CategoryService;
import ua.lviv.lgs.money.service.MoneyAccountService;
import ua.lviv.lgs.money.service.TransactionService;
import ua.lviv.lgs.money.service.UserService;

import java.math.BigDecimal;
import java.time.Instant;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private MoneyAccountService moneyAccountService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CategoryService categoryService;
 
    @Override
    public void run(String...args) throws Exception {
        User user = new User();
        user.setFirstName("Jon");
        user.setLastName("Snow");
        user.setUsername("jonsnow");

        userService.create(user);

        Currency currency = new Currency();
        currency.setCode("UAH");
        currency.setName("Ukrainian Hryvna");
        currencyRepository.save(currency);

        MoneyAccount moneyAccount = new MoneyAccount();

        moneyAccount.setCurrency(currency);
        moneyAccount.setName("Main account");
        moneyAccount.setInitialBalance(new BigDecimal(0));
        moneyAccount.setInitialDate(Instant.now());

        moneyAccountService.create(user.getId(), moneyAccount);

        userService.setCurrentAccount(user.getId(), moneyAccount);

        Category category = new Category();
        category.setName("Food");
        category.setType(Type.EXPENSE);

        categoryService.create(category);

        Transaction transaction = new Transaction();

        transaction.setAmount(new BigDecimal(100));
        transaction.setDate(Instant.now());
        transaction.setType(Type.EXPENSE);
        transaction.setCategory(category);

        transactionService.create(user.getId(), transaction);

    }
}