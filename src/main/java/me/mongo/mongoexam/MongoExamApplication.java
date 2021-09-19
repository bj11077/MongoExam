package me.mongo.mongoexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class MongoExamApplication {

    //1.탬플릿사용
    //몽고db 탬플릿으로 사용할수도있음
//    @Autowired
//    MongoTemplate mongoTemplate;

    @Autowired
    AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongoExamApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(){
        return args -> {
            Account account = new Account();
            account.setEmail("ccc@ddddd");
            account.setUsername("awer");

            // 1. 탬플리사용
            //            mongoTemplate.insert(account);
            accountRepository.insert(account);
            System.out.println("insert");
        };
    }

}
