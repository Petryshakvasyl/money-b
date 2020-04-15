package ua.lviv.lgs.money.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ua.lviv.lgs.money.domain.Category;
import ua.lviv.lgs.money.domain.Transaction;
import ua.lviv.lgs.money.repository.CategoryRepository;
import ua.lviv.lgs.money.service.dto.TransactionDTO;
import ua.lviv.lgs.money.service.exceptions.EntityNotFoundException;

@Component
@RequiredArgsConstructor
public class TransactionMapper {

    private final CategoryRepository categoryRepository;

    public Transaction toEntity(TransactionDTO transactionDTO) {
        Transaction result = new Transaction();
        result.setDate(transactionDTO.getDate());
        result.setDescription(transactionDTO.getDescription());
        result.setAmount(transactionDTO.getAmount());
        Category category = categoryRepository.findById(transactionDTO.getCategoryId()).orElseThrow(
                () -> new EntityNotFoundException("Category with id " + transactionDTO.getCategoryId() +
                        " was not found"));
        result.setCategory(category);
        result.setType(transactionDTO.getType());
        return result;
    }

    public TransactionDTO toDTO(Transaction transaction) {
        TransactionDTO result = new TransactionDTO();
        result.setDate(transaction.getDate());
        result.setDescription(transaction.getDescription());
        result.setAmount(transaction.getAmount());
        result.setCategoryId(transaction.getCategory().getId());
        result.setType(transaction.getType());
        return result;
    }

}
