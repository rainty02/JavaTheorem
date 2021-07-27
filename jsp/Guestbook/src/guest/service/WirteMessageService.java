package guest.service;

import java.sql.Connection;
import java.sql.SQLException;

import guest.dao.MessageDao;
import guest.domain.Message;
import guest.domain.MessageRequest;
import guest.jdbc.ConnectionProvider;
import guest.jdbc.JdbcUtil;

public class WirteMessageService {
	
	private WirteMessageService() {}
	private static WirteMessageService service = new WirteMessageService();
	public static WirteMessageService getInstance() {
		return service;
	}
	
	// 메시지를 DB에 쓰고 처리된 결과를 생성, 반환
	public int  wirteMessage(MessageRequest requestMessage ) {
		
		int resultCnt = 0;
		
		// 트랜잭션 처리를 위해 생성
		Connection conn = null;
		MessageDao dao = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MessageDao.getInstance();
			
			// AutoCommit의 기본값은 true : 자동커밋
			// Java Jdbc에서 트랜잭션을 컨트롤 : false, rollback
			conn.setAutoCommit(false);
			
			// 데이터 전처리가 필요한 부분은 처리
			Message message = requestMessage.toMessage();
			
			resultCnt = dao.wirteMessage(conn, message);
			
			// 트랜잭션 완료
			conn.commit();
			
		} catch (SQLException e) {
			// 트랜잭션 롤백
			JdbcUtil.rollback(conn);
			e.printStackTrace();
		}
		

		return resultCnt;
	}
	
}
