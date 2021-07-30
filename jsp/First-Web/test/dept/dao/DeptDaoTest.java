package dept.dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dept.domain.Dept;
import jdbc.util.ConnectionProvider;

public class DeptDaoTest {

	// 테스트에 필요한 객체 선언
	DeptDao dao;
	Connection conn;
	Dept insertDummy;
	Dept selectDummy;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// 초기화
		dao = DeptDao.getInstance();
		conn = ConnectionProvider.getConnection();
		insertDummy = new Dept(100, "개발팀", "서울");
		selectDummy = new Dept(10, "ACCOUNTING", "NEW YORK");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test 
	public void testGetDeptList() {
		assertEquals("deptList - deptno 비교", 10, dao.getDeptList(conn).get(0).getDeptno());
		assertEquals("deptList - deptno 비교", 20, dao.getDeptList(conn).get(1).getDeptno());
		assertEquals("deptList - deptno 비교", 30, dao.getDeptList(conn).get(2).getDeptno());
		assertEquals("deptList - deptno 비교", 40, dao.getDeptList(conn).get(3).getDeptno());
	}

	@Test
	public void testInsertDept() {
		assertEquals("더미 데이터 추가", 1, dao.insertDept(conn, insertDummy));
	}

	@Test
	public void testDeleteDept() {
		assertEquals("더미 데이터 삭제", 1, dao.deleteDept(conn, insertDummy.getDeptno()));
	}

	@Test
	public void testSelectByDeptno() {
		assertEquals("선택한 deptno의 toString 비교", selectDummy.toString(), dao.selectByDeptno(conn, selectDummy.getDeptno()).toString());
	}

	@Test
	public void testUpdateDept() {
		assertEquals("더미데이터 업데이트", 1, dao.updateDept(conn, selectDummy));
	}

}
