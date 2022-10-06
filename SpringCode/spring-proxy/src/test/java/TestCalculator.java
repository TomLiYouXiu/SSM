import com.liyouxiu.spring.proxy.Calculator;
import com.liyouxiu.spring.proxy.CalculatorImpl;
import com.liyouxiu.spring.proxy.ProxyFactory;
import org.junit.Test;

/**
 * @author liyouxiu
 * @date 2022/10/3 14:32
 */
public class TestCalculator {

    @Test
    public void testCalculator(){
//        CalculatorImpl calculator = new CalculatorImpl();
//        calculator.add(1,2);
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator)proxyFactory.getProxy();
        proxy.div(1,0);

    }
}
