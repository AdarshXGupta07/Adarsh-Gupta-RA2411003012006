package bank.repository;

import bank.account.Account;
import java.util.HashMap;
import java.util.Map;

public class InMemoryAccountRepository implements AccountRepository {

    private Map<Integer, String> map = new HashMap<>();

    public void save(Account acc) {
        map.put(acc.getAccNo(), acc.getAccNo() + "," + acc.getName() + "," + acc.getBalance());
        System.out.println("Saved account " + acc.getAccNo() + " in memory");
    }

    public String find(int accNo) {
        return map.get(accNo);
    }
}
