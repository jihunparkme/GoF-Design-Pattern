package me.whiteship.designpatterns._02_structural_patterns._06_adapter.practice;

import me.whiteship.designpatterns._02_structural_patterns._06_adapter.practice.security.UserDetails;

// Adapter
public class AccountUserDetails implements UserDetails {

    // Adaptee
    private Account account;

    public AccountUserDetails(Account account) {
        this.account = account;
    }

    @Override
    public String getUsername() {
        return account.getName();
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }
}
