package me.whiteship.designpatterns._02_structural_patterns._06_adapter.practice;

public interface UserDetailsService {

    UserDetails loadUser(String username);

}
