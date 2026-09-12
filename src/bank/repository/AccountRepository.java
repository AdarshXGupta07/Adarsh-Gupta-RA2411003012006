package bank.repository;

import bank.account.Account;

public interface AccountRepository {
    void save(Account acc);
    String find(int accNo);
}
