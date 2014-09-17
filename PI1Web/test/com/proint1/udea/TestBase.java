package com.proint1.udea;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Test base para todos los test de la aplicación
 * @author Juan Carlos Cardona
 * @since  24/05/2014
 * @version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:WEB-INF/applicationContext.xml")
public class TestBase {
    

    @Before
    public void beforTest(){
    }
}
