package test.java.com.liyouxiu.maven;
	
import org.junit.Test;
import main.java.com.liyouxiu.maven.Calculator;

// 测试方式
// 通过import语句将要测试的类引入当前类，引入后
// 通过编译：可以使用则这个范围的依赖可以使用
// 编译失败：不能使用这个范围的依赖则不可以使用
import main.java.com.liyouxiu.maven.Calculator;

// test 目录下的java类：CalculatorTest
// compile 范围引入的依赖 pro_maven_java
// pro_maven_java 中的类Calculator
	
// 静态导入的效果是将Assert类中的静态资源导入当前类
// 这样一来，在当前类中就可以直接使用Assert类中的静态资源，不需要写类名
import static org.junit.Assert.*;
	
public class CalculatorTest{
	
	@Test
	public void testSum(){
		
		// 1.创建Calculator对象
		Calculator calculator = new Calculator();
		
		// 2.调用Calculator对象的方法，获取到程序运行实际的结果
		int actualResult = calculator.sum(5, 3);
		
		// 3.声明一个变量，表示程序运行期待的结果
		int expectedResult = 8;
		
		// 4.使用断言来判断实际结果和期待结果是否一致
		// 如果一致：测试通过，不会抛出异常
		// 如果不一致：抛出异常，测试失败
		assertEquals(expectedResult, actualResult);

        System.out.println("test method been called");
		
	}
	
}