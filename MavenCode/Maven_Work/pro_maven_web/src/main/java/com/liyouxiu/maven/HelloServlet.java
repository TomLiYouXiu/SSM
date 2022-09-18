package main.java.com.liyouxiu.maven;
	
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

// 具体测试代码如下

// 测试方式
// 通过import语句将要测试的类引入当前类，引入后
// 通过编译：可以使用则这个范围的依赖可以使用
// 编译失败：不能使用这个范围的依赖则不可以使用
import main.java.com.liyouxiu.maven.Calculator;

// main 目录下的java类：HelloServlet
// compile 范围引入的依赖 pro_maven_java
// pro_maven_j 中的类Calculator

// test 范围引入的依赖：Junit
// Junit中可以使用注解：@Test
// import org.junit.Test;

// 验证目标
public class HelloServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().write("hello maven web");
		
	}
	
}