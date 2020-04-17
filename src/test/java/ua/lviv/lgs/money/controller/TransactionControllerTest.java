package ua.lviv.lgs.money.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import ua.lviv.lgs.money.domain.Currency;
import ua.lviv.lgs.money.domain.MoneyAccount;
import ua.lviv.lgs.money.domain.User;
import ua.lviv.lgs.money.repository.CurrencyRepository;
import ua.lviv.lgs.money.repository.MoneyAccountRepository;
import ua.lviv.lgs.money.repository.TransactionRepository;
import ua.lviv.lgs.money.repository.UserRepository;

import static org.hamcrest.Matchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MoneyAccountRepository moneyAccountRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @BeforeEach
    void setUp() {
        Currency currency = new Currency();
        currency.setName("UAH");
        currency.setCode("UAH");
        currencyRepository.save(currency);
        MoneyAccount moneyAccount = new MoneyAccount();
        moneyAccount.setName("account");
        moneyAccount.setCurrency(currency);
        moneyAccountRepository.save(moneyAccount);
        User user = new User();
        user.setUsername("user");
        user.setPassword("pass");
        user.setFirstName("user");
        user.setLastName("lastName");
        user.setEmail("user@mail.com");
        user.setCurrentAccount(moneyAccount);
        userRepository.save(user);
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
        moneyAccountRepository.deleteAll();
        currencyRepository.deleteAll();
    }

    @Test
    void getIncomePageWhenResultIsEmpty() throws Exception {
        mockMvc.perform(get("/transactions/income").with(user("user").password("pass").roles("USER")))
                .andExpect(status().isOk())
                .andExpect(view().name("income"))
                .andExpect(model().attribute("incomePage", hasProperty("content", is(empty()))));
    }

    @Test
    void getIncomePage() throws Exception {

        mockMvc.perform(get("/transactions/income").with(user("user").password("pass").roles("USER")))
                .andExpect(status().isOk())
                .andExpect(view().name("income"))
                .andExpect(model().attribute("incomePage", hasProperty("content", is(hasSize(1)))));
    }

    @Test
    void getExpensePage() {
    }

    @Test
    void createTransaction() {
    }

    @Test
    void testCreateTransaction() {
    }
}