package me.whiteship.designpatterns._02_structural_patterns._06_adapter.practice;


import me.whiteship.designpatterns._02_structural_patterns._06_adapter.practice.security.UserDetails;
import me.whiteship.designpatterns._02_structural_patterns._06_adapter.practice.security.UserDetailsService;

// Adapter
public class AccountUserDetailsService implements UserDetailsService {

    // Adaptee
    private AccountService accountService;

    public AccountUserDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUser(String username) {
        return new AccountUserDetails(accountService.findAccountByUsername(username));
    }
}
