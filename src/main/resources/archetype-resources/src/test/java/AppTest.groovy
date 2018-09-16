package ${packageName}

import org.junit.runner.RunWith
import org.junit.Test

import org.springframework.test.context.junit4.SpringRunner
import org.springframework.boot.test.context.SpringBootTest

@RunWith(SpringRunner)
@SpringBootTest
public class AppTest extends GroovyTestCase {
    /**
     * Rigourous Test :-)
     */
    @Test
    public void testTrue() {
        assert true
    }
}
