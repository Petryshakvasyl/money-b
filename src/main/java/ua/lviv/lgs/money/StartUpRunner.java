//package ua.lviv.lgs.money;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//import ua.lviv.lgs.money.domain.*;
//import ua.lviv.lgs.money.domain.enumeration.Type;
//import ua.lviv.lgs.money.repository.CurrencyRepository;
//import ua.lviv.lgs.money.repository.MoneyAccountRepository;
//import ua.lviv.lgs.money.repository.TransactionRepository;
//import ua.lviv.lgs.money.service.CategoryService;
//import ua.lviv.lgs.money.service.UserService;
//
//import java.io.InputStream;
//import java.math.BigDecimal;
//import java.time.Instant;
//import java.time.temporal.ChronoUnit;
//import java.util.List;
//import java.util.Optional;
//import java.util.concurrent.ThreadLocalRandom;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//@Component
//@RequiredArgsConstructor
//public class StartUpRunner implements CommandLineRunner {
//
//    private final UserService userService;
//
//    private final CategoryService categoryService;
//
//    private final CurrencyRepository currencyRepository;
//
//    private final MoneyAccountRepository moneyAccountRepository;
//
//    private final TransactionRepository transactionRepository;
//
//    @Override
//    @Transactional
//    public void run(String... args) throws Exception {
////        User user = userService.findById(1L);
//
//        List<Category> categoryList = categoryService.findAll();
//        //        MoneyAccount moneyAccount = new MoneyAccount();
//        //        moneyAccount.setInitialDate(Instant.now().minus(30, ChronoUnit.DAYS));
//        //        moneyAccount.setCurrency(currencyRepository.findAll().get(0));
//        //        moneyAccount.setName("My");
//        //        user.getAccounts().add(moneyAccount);
//        //        user.setCurrentAccount(moneyAccount);
//        MoneyAccount moneyAccount = moneyAccountRepository.findById(115L).get();
//
//        List<Transaction> transactions = IntStream.range(0, 150).mapToObj(i -> {
//            Category category = categoryList.get(ThreadLocalRandom.current().nextInt(categoryList.size()));
//            Transaction transaction = new Transaction();
//            transaction.setCategory(category);
//            transaction.setType(category.getType());
//            transaction.setAmount(BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(500)));
//            transaction.setDate(Instant.now().minus(ThreadLocalRandom.current().nextInt(30), ChronoUnit.DAYS));
//            transaction.setMoneyAccount(moneyAccount);
//            return transaction;
//        }).collect(Collectors.toList());
//        transactionRepository.saveAll(transactions);
//
//        moneyAccount.getTransactions().addAll(transactions);
//
//    }
//
//}
