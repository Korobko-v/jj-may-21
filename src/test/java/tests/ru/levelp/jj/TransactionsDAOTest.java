package tests.ru.levelp.jj;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.levelp.jj.TestConfig;
import ru.levelp.jj.dao.TransactionsDAO;
import ru.levelp.jj.dao.UsersDAO;
import ru.levelp.jj.model.Transaction;
import ru.levelp.jj.model.User;

import java.util.Date;

import static org.springframework.test.util.AssertionErrors.fail;


@SpringBootTest
@ContextConfiguration(classes = TestConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TransactionsDAOTest {

    @Autowired
    private UsersDAO users;

    @Autowired
    private TransactionsDAO transactions;

    @Test
    public void create() {
        User sender = users.create("sender", "pass");
        User recipient = users.create("recipient", "pass");

        transactions.create(new Date(), 10.0, sender, recipient);

        try {
            transactions.create(new Date(), 10.0, sender, sender);
            fail("Shouldn't be possible to make transaction with same user");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void findByUser() {
        User sender = users.create("sender", "pass");
        User recipient = users.create("recipient", "pass");
        User other = users.create("other", "pass");

        Transaction tx = transactions.create(new Date(), 10.0, sender, recipient);


    }
}