package bank.repository;

import bank.account.Account;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileAccountRepository implements AccountRepository {

    private Path file;

    public FileAccountRepository(String fileName) {
        file = Paths.get(fileName);
    }

    // one line per account: accNo,name,balance
    public void save(Account acc) {
        List<String> lines = readLines();
        String line = acc.getAccNo() + "," + acc.getName() + "," + acc.getBalance();

        int i;
        for (i = 0; i < lines.size(); i++) {
            if (lines.get(i).startsWith(acc.getAccNo() + ",")) {
                lines.set(i, line);
                break;
            }
        }
        if (i == lines.size()) {
            lines.add(line);
        }

        try {
            Files.write(file, lines);
        } catch (IOException e) {
            System.out.println("Could not write " + file);
        }
        System.out.println("Saved account " + acc.getAccNo() + " in " + file);
    }

    public String find(int accNo) {
        for (String line : readLines()) {
            if (line.startsWith(accNo + ",")) {
                return line;
            }
        }
        return null;
    }

    private List<String> readLines() {
        try {
            if (Files.exists(file)) {
                return new ArrayList<>(Files.readAllLines(file));
            }
        } catch (IOException e) {
            System.out.println("Could not read " + file);
        }
        return new ArrayList<>();
    }
}
