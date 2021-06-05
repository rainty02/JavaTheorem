package com.networking;

public class Networking {}

/*
 * 		네트워킹 Networking
 * 		client - server 실시간으로 데이터를 주고 받는 것
 * 		WAN > MAN > LAN > PAN
 * 
 * 		용어
 * 		node 노드
 * 		네트워크에 연결된 장치
 * 		컴퓨터, 프린터, 라우터, 브릿지, 게이트웨이, 터미널등
 * 
 * 		address 주소
 * 		노드를 유일하게 구별해주는 일련의 바이트
 * 		네트워크 종류에 따라 다르게 할당됨
 * 
 * 		domain 도메인
 * 		노드를 기억하기 쉽도록 노드에 부여한 이름
 * 		문자로 만든 인터넷 주소
 * 
 * 		packet-switched 패킷 교환
 * 		데이터를 작은 단위(패킷)로 분리하여 네트워크 회선 공유
 * 		송신자와 수신자의 정보 포함
 * 
 * 		protocol 프로토콜
 * 		HTTP(Hypertext Tranfer Protocol)
 * 		: 웹 브라우저와 웹 서버가 통신하는 방법
 * 		IEEE802.3: 물리적 전선에서 비트가 전기적인 신호로 바뀌는 방법 정의
 * 
 * 		IP(internet protocol)
 * 		군사적인 특성 내포
 * 		두 지점 사이의 여러 경로를 허용하고 손상된 라우터 주변 데이터 패킷을 라우팅 할 수 있도록 설계
 * 
 * 		TCP(Transmiossion Control Protocol) 1:1 ex : 전화
 * 		IP 프로코톨 위에서 연결형 서비스 제공
 * 		각 연결의 끝에 IP패킷의 수신 여부 확인 기능과 손상되거나 손실된 패킷에 대한 재전송 요청 기능 추가
 * 
 * 		UDP(user Datagram protocol) 1:n ex : 라디오
 * 		사용 데이터그램 프로토콜
 * 		보내는 쪽에서 일방적으로 데이터를 전달
 * 
 * 		Port
 * 		TCP와 UDP가 상위 계층에 제공하는 주소 표현 방식
 * 		1~65535 숫자로 표현
 * 		1~1023 FTP, HTTP와 같이 잘 알려진 서비스를 위해 미리 예약
 * 
 * 		인터넷
 * 		IP 프로토콜을 사용하는 컴퓨터들의 집단
 * 
 * 		인터넷 주소 클래스
 * 		InterNIC(Internet Newwork Infomation Center) 할당
 * 		A, B, C class는 네트워크용, d class는 멀티캐스팅, E class는 예비용
 * 
 * 
 * 		TCP/IP 4계층
 * 		1. 네트워크 인터페이스 계층
 * 			네트워크 인터페이스가 물리적인 연결을 통해 로컬 네트워크 및 외부 IP 데이터그램을 전공하는 방법을 제공
 * 			TCP/IP 패킷을 네트워크 매체로 전달하는 것과 네트워크 매체에서 패킷을 받아들이는 과정을 담당
 * 		2. 인터넷계층
 * 			어드레싱, 패키징, 라우팅 기능을 제공
 * 			논리적 주소인 IP를 이용한 노드간 전송과 라우팅 기능을 처리
 *			네트워크상 최종 목적지까지 정확하게 연결되도록 연결성 제공
 *
 *		3. 전송계층 (tranport)
 *			데이터의 송수신을 담당
 *			애플리케이션 계층의 세션과 데이터그램 통신서비스 제공
 *			핵심 프로토콜로 TCP/UDP가 있음
 *			TCP - 1:1 연결지향, 신뢰할 수 있는 통신서비스 제공, 손상된 패킷을 복구하는 역할
 *			UDP - 1:1, 1:n의 비연결지향, 신뢰할 수 없는 통신서비스 제공, TCP 연결 확립에 의한 부하를 피할 때 사용
 *
 *		4. 응용프로그램 (Application)
 *			다른 계층의 서비스에 접근할 수 있게 하는 애플리케이션을 제공하는 계층
 *			애플리케이션들이 데이터를 교환하기 위해 사용하는 프로토콜들을 정의하고 있음
 *			- HTTP (HyperText transfer Protocol)
 *			www의 web 페이지 파일을 전송하는데 사용
 * 			- FTP (File transfer Protocol)
 * 			상호 파일 전송을 위해 사용
 * 			- SMTP (Simple Mail transfer Protocol)
 * 			메일 메시지와 그에 추가된 첨부파일을 전송하는데 사용
 * 			- Telnet (Terminal emulation protocol)
 *			네트워크 호스트에 원격 저속하는 위해 사용
 *			- DNS (Domain Name System)
 *			호스트 이름을 IP 주소로 변환하기 위해 사용 * 
 * 
 * 
 * 		InetAddress 클래스
 * 		IP주소를 표현하고 제어하는 기능을 제공하는 클래스
 * 		호스트 네임자체를 가지고 주소를 표현해 그에 관련된 기능을 제공
 * 		인스턴스 생성법
 * 		생성자 없음, static 메서드를 사용하여 인스턴스를 생성
 * 		public static InetAddress getByName String Host throws UnknownHostException
 * 		호스트의 이름 또는 주소를 InetAddress로 전환
 * 		
 * 
 * 		URL(uniform resource locator)
 * 		인터넷 상의 자원에 대한 주소
 * 		프로토콜의 종류, 도메인 이름, 포트, 경로명, 파일이름, 쿼리스트링
 * 		프로토콜 - http
 * 				://
 * 		도메인 이름 - www.naver.com
 * 				:
 * 		포트 - 80
 * 				/
 * 		경로/파일 - sun.html
 * 				?
 * 		파라미터(쿼리) - page=bool_list
 * 		anchor - #new
 * 
 *
 * 		URI
 * 		URI(uniform resource identifier)
 * 		인터넷에 있는 어떤 자원에 접근하기 위한 유일한 주소 또는 키
 * 		uri만 있으면 웹에 있는 자원에 간단하게 접속가능
 * 
 * 		
 * 
 * 		Socket Programming
 * 		다른 JRE에서 실행되는 응용 프로그램 간의 통신에 사용.
 * 		연결지향 소켓프로그래밍 (연결 우선)
 * 		서버의 ip주소, 포트번호 두가지를 알아야 통신가능
 * 		socket 클래스와 serversocket 클래스
 * 		클라이언트에서 서버에 요청을 하면
 * 		serversocket클래스에서 socket클래스를 객체생성
 * 
 * 		socket클래스
 * 		소켓은 단순히 시스템 간의 통신을 위한 끝점을 의미
 * 		socket클래스를 사용하여 소켓을 만듦
 * 		소켓 인스턴스를 생성하기 위해서는 서버 소켓의 ip주소, port 번호가 필요
 * 		소켓 연결이 가능한 서버가 실행중이어야함
 * 		Socker s = new Socket("localhost", 9999); /주소, 포트
 * 
 * 		ServerSocket클래스
 * 		ServerSocket클래스를 사용해 서버 소켓을 만듦
 * 		이 인스턴스는 클라이언트 소켓과 연결하여 통신할 수 있는 소켓 인스턴스 생성
 * 		포트번호 9999 사용
 * 		ServerSocket 인스턴스의 accept()메소드를 이용해 클라이언트의 소켓객체가 만들어질 때까지 대기상태
 * 		
 * 		
 * 
 * 
 * 
 * 
 * 
 * 
 */

