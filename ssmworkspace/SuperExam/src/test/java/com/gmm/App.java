package com.gmm;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * Created by JW.
 * User: JW
 * Date: Sep 26, 2016 
 * Time: 3:35:06 PM
 *
 * com.gmm.App
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public abstract class App {
    @Autowired
    protected ApplicationContext applicationContext;
}
