package ru.savchenko.andrey.maginttest2;

import org.junit.Before;
import org.junit.Test;

import ru.savchenko.andrey.maginttest2.network.RequestManager;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Before
    public void setup(){
        RequestManager.init();
    }

    @Test
    public void testRequest(){

    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
}