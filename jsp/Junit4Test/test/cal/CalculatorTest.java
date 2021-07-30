package cal;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

	// 객체, 변수 선언 위치
	//Calculator cal = new Calculator();
	Calculator cal;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("@Before");
		// 객체, 변수 초기화 위치
		cal = new Calculator();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After");
	}

	@Test
	public void testAdd() {
		System.out.println("testAdd()");
		
		//Calculator cal = new Calculator();
		
		// 메시지, 기댓값, 메소드 실행
		assertEquals("add() 테스트", 12, cal.add(10, 2));
		
		//System.out.println(cal.add(10, 2));
		
		//fail("Not yet implemented");
	}

	@Test
	public void testSubstract() {
		System.out.println("testSubstract()");
		assertEquals("substarct() 테스트", 8, cal.substract(10, 2));
		//fail("Not yet implemented");
	}

	@Test
	public void testMultiply() {
		System.out.println("testMultiply()");
		assertEquals("testMultiply() 테스트", 20, cal.multiply(10, 2));
		//fail("Not yet implemented");
	}

	@Test
	public void testDivide() {
		System.out.println("testDivide()");
		assertEquals("testDivide() 테스트", 5, cal.divide(10, 2));
		//fail("Not yet implemented");
	}

	// 예외 타입을 비교해서 테스트
	@Test(expected = SQLException.class)
	public void testException() throws SQLException {
		System.out.println("@Test 실행 중 예외타입 테스트");
		//throw new ArithmeticException();
		throw new SQLException();
	}
	
	
	@Test(timeout = 1) // 1/1000 s
	public void testTimeout() {
		System.out.println("@Test 테스트가 허용시간 ms안에 실행이 완료되는지");
		cal.add(10, 2);
	}
	
	@Test
	public void testFail() {
		// 실패
		fail("테스트 미실행");
	}
	
	@Test
	public void testBooleanTrue() {
		assertTrue("메소드의 반환값이 boolean인 경우 사용", true);
	}
	
	@Test
	public void testBooleanFalse() {
		assertFalse("메소드의 반환값이 boolean인 경우 사용", false);
	}
	
	@Test
	public void testNull() {
		assertNull("메소드의 실행값이 null이 예상되는 경우", null);
	}
	
	@Test
	public void testNotNull() {
		assertNotNull("메소드의 실행값이 null이 예상되는 경우", new Object());
	}
	
	@Test
	public void testSame() {
		assertSame("값이 같을 경우 ", 1, 1);
	}
	
	@Test
	public void testNotSame() {
		assertNotSame("값이 다를 경우 ", 1, 2);
	}
}

















