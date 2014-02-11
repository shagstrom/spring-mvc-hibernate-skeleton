package com.dreamchain.skeleton.dao.impl;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:testContext.xml")
@TestExecutionListeners({TransactionalTestExecutionListener.class})
@TransactionConfiguration(transactionManager = "transactionManager")
public abstract class DaoTest extends AbstractJUnit4SpringContextTests {

}
