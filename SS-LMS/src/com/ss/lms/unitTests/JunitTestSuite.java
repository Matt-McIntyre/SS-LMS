package com.ss.lms.unitTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   TestAuthor.class,
   TestPublisher.class,
   TestBook.class,
   TestApp.class
})

public class JunitTestSuite {   
}  	