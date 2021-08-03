package member.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import member.dao.Dao;
import member.dao.MemberDao;
import member.domain.RegRequest;
import member.service.ChangePasswordService;
import member.service.MemberRegService;

public class SpringMain2 {

	static ApplicationContext ctx;
	
	public static void main(String[] args) {
		
		//ctx = new GenericXmlApplicationContext("classpath:appCtx1.xml");
		//ctx = new GenericXmlApplicationContext("classpath:appCtx2.xml");
		ctx = new GenericXmlApplicationContext("classpath:appCtx4.xml");
		
		// MemberRegService 객체를 컨테이너로부터 받아온다 ==
		System.out.println("=========================");
		// scope = singleton : true / 시작시 인스턴스 생성
		Dao dao1 = ctx.getBean("memberDao", Dao.class);
		Dao dao2 = ctx.getBean("memberDao", Dao.class);
		System.out.println("dao1==dao2 : " + (dao1==dao2));
		
		// scope = prototype : false / 요청시 인스턴스 생성 : 필요할 때마다 생성해야할 때 사용
		MemberRegService regService1 = ctx.getBean("regService", MemberRegService.class);
		MemberRegService regService2 = ctx.getBean("regService", MemberRegService.class);	
		System.out.println("regService1==regService2 : " + (regService1==regService2));
		
		// scope = singleton : true
		ChangePasswordService pwService1 = ctx.getBean("changePwService", ChangePasswordService.class);
		ChangePasswordService pwService2 = ctx.getBean("changePwService", ChangePasswordService.class);
		System.out.println("pwService1==pwService2 : " + (pwService1==pwService2));
	}

}
