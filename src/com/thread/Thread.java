package com.thread;

public class Thread {
	
}

/*
 * 		thread 쓰레드
 * 		작업 스케줄러에 의해 시간을 배정받아 cpu에서 작업할 수 있는 단위
 * 		성능(=시간)향상을 위해 사용 - 사용할 때마다 지정된 메모리를 공유
 * 		단일스레드 - 순서대로 작업
 * 
 * 		다중스레드 - 동시에 작업
 * 		일반적으로 단일 cpu 환경에서는 단위시간에 하나의 프로그램만 실행
 * 		시분할 기법
 * 		멀티태스킹 및 멀티스레드를 가능하게 하는 기법
 * 		아주 짧은 시간 간격을 두고 여러개의 프로그램을 전환하면서 실행
 * 		빠른 속도 때문에 두개이상의 프로그램이 동시에 실행되는 것처럼 느껴짐
 * 		프로그램의 실행을 전환하는 것은 os가 담당
 * 
 * 		장점
 * 		자원을 효율적으로 사용
 * 		사용자에 대한 응답성이 향상
 * 		작업이 분리되어 코드가 간결해짐
 * 		단점
 * 		*동기화에 주의 (동시성 문제)
 * 		교착상태(프로그램들의 대기상태)가 발생하지 않도록 주의해야함
 * 
 * 		Thread 클래스를 상속
 * 		run() 오버라이딩 // 직접 호출하는 메소드X *start로 시작됨
 *		ThreadEx1_1 t1 = new TreadEx1_1();
 *
 *		Runnable 인터페이스를 구현
 *		run() 구현 
 *		Runnable r = new TreadEX1_2();
 *		Tread t2 = new Tread(r); Runnable타입		
 * 
 * 
 * 		쓰레드의 라이프 사이클
 * 		쓰레드 상태변화
 * 		프로세서를 같이 사용하고 항상 한 쓰레드만이 실행
 * 		한 프로세스 안에 있는 쓰레드는 순차적으로 실행 - 순서는? 가상머신
 * 		한번 종료된 쓰레드는 소멸
 * 		Blocked(join, sleep등) 상태는 상태변화에 따라 사용가능
 * 
 * 
 * 		동기화
 * 		둘이상의 스레드가 하나의 메모리 공간에 동시 접근할 경우 동시성의 문제가 생심
 * 		하나의 스레드가 공유된 변수를 사용하고 있는동안
 * 		다른 스레드가 사용이 끝날 때까지 대기해서 순차적으로 처리하도록
 * 		스레드의 대기상태들이 겹치게 되면 교착상태가 되므로 주의
 * 		synchronized 선언으로 해당 메소드는 스레드에 안전한 함수가 됨
 * 		그러나 다음 스레드가 계속 딜레이되므로 성능의 감소가 동반됨
 * 		동기화에 사용되는 인스턴스는 하나이며, 이 인스턴스에는 하나의 열쇠만이 존재
 * 		메소드의 일부에 접근하는 경우에는 메소드 전체를 동기화하는 것은 비효율적
 * 		이를 개선한 것이 동기화블럭 - 동기화의 대상이 되는 영역을 제한
 * 
 * 		public int ...... {
 * 			synchronized(this) { // this는 자기 자신. 동기화의 대상
 * 				opCnt++;
 * 			}
 * 		}
 * 		동기화해야하는 메소드가 여러개일 경우 같은 this를 넣어주면 실행할 메소드를 헛갈리게 함
 * 		메소드의 성격에 따라 키값을 달리해줘야 한다
 * 		Object key = new Object();	빈 인스턴스를 만들어 키값으로 사용
 * 
 * 
 * 
*/