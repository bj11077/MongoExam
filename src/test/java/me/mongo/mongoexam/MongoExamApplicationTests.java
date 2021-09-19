package me.mongo.mongoexam;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.*;

import java.util.Optional;

@SpringBootTest
@DataMongoTest
class MongoExamApplicationTests {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void findByEmail() {
        Account account = new Account();
        account.setUsername("nndd");
        account.setEmail("nndd@gmail.com");
        accountRepository.save(account);
        Optional<Account> byId = accountRepository.findById(account.getId());
        System.out.println(byId);
        accountRepository.findByEmail(account.getEmail());
        System.out.println(accountRepository.findByEmail(account.getEmail()));
    }

}
