package com.turkcell.crm.accountService.accountService.api.controllers;

import com.turkcell.crm.accountService.accountService.business.abstracts.AccountService;
import com.turkcell.crm.accountService.accountService.business.dtos.requests.Account.CreateAccountRequest;
import com.turkcell.crm.accountService.accountService.business.dtos.requests.Account.UpdateAccountRequest;
import com.turkcell.crm.accountService.accountService.business.dtos.responses.Account.CreatedAccountResponse;
import com.turkcell.crm.accountService.accountService.business.dtos.responses.Account.GetAccountResponseById;
import com.turkcell.crm.accountService.accountService.business.dtos.responses.Account.GetAllAccountResponse;
import com.turkcell.crm.accountService.accountService.business.dtos.responses.Account.UpdatedAccountResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/accounts")
public class AccountsController {

    private AccountService accountService;

    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllAccountResponse> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetAccountResponseById getById(@PathVariable int id) {
        return accountService.getAccountById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        accountService.delete(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedAccountResponse update(@Valid  @RequestBody UpdateAccountRequest updateAccountRequest) {
        return accountService.update(updateAccountRequest);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedAccountResponse add(@Valid @RequestBody CreateAccountRequest createAccountRequest) {
        return accountService.add(createAccountRequest);
    }
}
