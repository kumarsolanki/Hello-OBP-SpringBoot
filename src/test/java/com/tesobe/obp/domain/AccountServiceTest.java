package com.tesobe.obp.domain;

import com.tesobe.obp.AbstractTestSupport;
import com.tesobe.obp.api.ObpApiClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest extends AbstractTestSupport {

    @Autowired private ObpApiClient obpApiClient;

    @Test
    public void fetchPrivateAccountsNoDetailsOk() {
        //fetch private accounts
        List<Account> privateAccounts = obpApiClient.getPrivateAccountsNoDetails();
        assertTrue(privateAccounts.size() > 0);
    }

    @Test
    public void fetchPrivateAccountsWithDetailsOk() {
        //fetch private accounts
        List<Account> privateAccounts = obpApiClient.getPrivateAccountsWithDetails();
        assertTrue(privateAccounts.size() > 0);
        privateAccounts.forEach(privateAccount -> assertNotNull(privateAccount.getBalance()));
    }
}