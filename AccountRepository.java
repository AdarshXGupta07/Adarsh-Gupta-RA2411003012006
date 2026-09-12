public interface AccountRepository {
    void save(Account acc);
    String find(int accNo);
}
