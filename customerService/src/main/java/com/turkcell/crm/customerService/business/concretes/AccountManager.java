package com.turkcell.crm.customerService.business.concretes;

import com.turkcell.crm.customerService.business.abstracts.AccountService;
import com.turkcell.crm.customerService.business.dtos.requests.Account.CreateAccountRequest;
import com.turkcell.crm.customerService.business.dtos.requests.Account.UpdateAccountRequest;
import com.turkcell.crm.customerService.business.dtos.responses.Account.CreatedAccountResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Account.GetAccountResponseById;
import com.turkcell.crm.customerService.business.dtos.responses.Account.GetAllAccountResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Account.UpdatedAccountResponse;
import com.turkcell.crm.customerService.core.utilities.mapping.ModelMapperService;
import com.turkcell.crm.customerService.dataAccess.abstracts.AccountRepository;
import com.turkcell.crm.customerService.entities.concretes.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class AccountManager implements AccountService {
    private ModelMapperService modelMapperService;
    private AccountRepository accountRepository;
    @Override
    public GetAccountResponseById getAccountById(int id) {
        Account account = accountRepository.findById(id).orElse(null);
        return this.modelMapperService.forResponse().map(account, GetAccountResponseById.class);
    }

    @Override
    public List<GetAllAccountResponse> getAll() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(
                account -> this.modelMapperService.forResponse().map(account, GetAllAccountResponse.class)
        ).toList();
    }

    @Override
    public CreatedAccountResponse add(CreateAccountRequest createAccountRequest) {
        Account account = this.modelMapperService.forRequest().map(createAccountRequest, Account.class);
        account.setCreatedDate(LocalDateTime.now());
        Account savedAccount = accountRepository.save(account);
        return this.modelMapperService.forResponse().map(savedAccount, CreatedAccountResponse.class);
    }

    @Override
    public UpdatedAccountResponse update(UpdateAccountRequest updateAccountRequest) {
        Account account = accountRepository.findById(updateAccountRequest.getId()).orElse(null);
        modelMapperService.forUpdate().map(updateAccountRequest, account);
        account.setUpdatedDate(LocalDateTime.now());
        Account savedAccount = accountRepository.save(account);
        return this.modelMapperService.forResponse().map(savedAccount, UpdatedAccountResponse.class);
    }

    @Override
    public void delete(int id) {
        //soft delete
        Account account = accountRepository.findById(id).orElse(null);
        account.setActive(false);
        account.setDeletedDate(LocalDateTime.now());
        accountRepository.save(account);
    }
}
