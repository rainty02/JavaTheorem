package member.main;

import java.util.Scanner;

import member.dao.MemberDao;
import member.domain.RegRequest;
import member.service.ChangePasswordService;
import member.service.MemberRegService;

public class MainForMembermanager {

	//static MemberDao dao = new MemberDao();
	
	static Assembler assembler = new Assembler(); 
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			
		while(true) {
			printMenu();
			
			String cmd = sc.nextLine();
			// 프로그램의 종료 분기
			if(cmd.equalsIgnoreCase("exit")) {
				System.out.println("프로그램 종료");
				return;
			}
			if(cmd.startsWith("new")) {
				String[] values= cmd.split(" ");
				processNewMember(values);
				continue;
			}
			if(cmd.startsWith("change")) {
				String[] values= cmd.split(" ");
				processChagnePw(values);
			}			
		}		
	}

	private static void processChagnePw(String[] values) {
		 
		//ChangePasswordService service = new ChangePasswordService(dao);
		ChangePasswordService service = assembler.getPasswordService();
		try {
			service.changePassword(values[1], values[2], values[3]);
			System.out.println("비밀번호를 변경했습니다.");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

	private static void processNewMember(String[] values) {

		// MemberRegService 이용해서 정보 저장
		//MemberRegService service = new MemberRegService(dao);
		MemberRegService service = assembler.getRegService();
		RegRequest request = new RegRequest();
		request.setEmail(values[1]);
		request.setName(values[2]);
		request.setPassword(values[3]);
		request.setConfirmPassword(values[4]);
		
		if(!request.isPasswordEqualToConfirmPassword()) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		try {
			service.regMember(request);
			System.out.println("등록되었습니다.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	static void printMenu() {
		System.out.println();
		System.out.println("명령어 사용법");
		System.out.println("회원 등록 ----------------");
		System.out.println("new 이메일 이름 비밀번호 확인");
		System.out.println("new king@gmail.com king 123 123");
		System.out.println("회원 수정 ----------------");
		System.out.println("change 이메일 현재비번 새로운비번");
		System.out.println("change king@gmail.com 123 0000");
		System.out.println("-----------------------");
		
	}
	
}
