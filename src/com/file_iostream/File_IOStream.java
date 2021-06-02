package com.file_iostream;

public class File_IOStream {

}
/*
 * 			 
 * 		입출력 대상이 달라지면 입출력 방식이 달라지는 것이 보통이지만
 * 		자바에서는 입출력 대상에 상관없이 동일하도록 별로의 I/O 모델을 정의하고 있음
 * 		
 * 		입출력(I/O)
 * 		입력Input과 출력Output
 * 		두 대상간의 데이터를 주고 받는 것
 * 
 * 		Stream(흐름, 연결통로)
 * 		기준 - java program
 * 		input(읽기) : file -Stream-> java program
 * 		output(쓰기) : java program -Stream-> file
 * 		*하나의 스트림으로 입출력 동시에 수행할 수 없음 (단방향 통신)
 * 		동시에 하려면 2개의 스트림이 필요 - 대부분 쌍(pair)을 이룸
 * 		FIFO구조 = Quequ와 같음
 * 		스트림은 지연될 수 있음
 * 
 * 		자바 입출력 스트림의 종류
 * 		바이트 스트림 
 * 		상위클래스 - *상속관계
 * 		InputStream - *FileInputStream, ObjectInputStream
 * 		OutputStream - *FileOutputStream, ObjectOutputStream
 * 		문자단위 / 바이트단위
 * 		1바이트씩 입출력
 * 		데이터의 기본단위
 * 		일반적으로 바이트로 구성된 파일을 처리하기에 적합
 * 		java.io 패키지 포함
 * 		InputStream in = new FileInputStream(경로);
 * 		스트림의 생성 = 인스턴스 생성
 * 
 * 
 * 		문자 스트림 
 * 		Reader - FileReader
 * 		Writer - FileWriter
 * 		유니코드(UTF-8)로 된 문자를 입출력하는 스트림
 * 		모든 언어로 구성된 파일을 입출력하기에 적합 - 타운영체제 호환성이 높음
 * 		char - 2바이트로 입출력 
 * 		이미지, 동영상과 같은 바이너리 데이터는 입출력 불가
 * 		문자 데이터만 입출력 가능
 * 		BufferedReader in = new BufferedReader(new FileReader("경로"));
 * 
 * 
 * 
 * 		필터 스트림 (보조 스트림)
 * 		단독 사용 불가
 * 		FileInputStream in = new FileInputStream("origin.pdf");
 * 		BufferedInputStream bin = new BufferedInputStream(in); - 경로가 아닌  파일인풋스트림 인스턴스를 넣어줌
 * 
 * 
 * 		직렬화(serialization)
 * 		객체를 연속적인 데이터로 변환하는 것. 반대과정은 역직렬화
 * 		객체의 모든 인스턴스 변수의 값을 저장하는 것
 *		복원하는 것을 역질렬화 
 *		transient - 직렬화 제외
 *		transient String 주민등록번호; 등 
 *
 *
 *		FILE 클래스
 *		파일의 경로명을 다루는 클래스
 *		파일 생성, 삭제 등 관리
 *		파일 입출력은 파일 스트림 이용
 *	
 *		*디렉토리 생성의 예
 *		File reDir = new File("C:\\Your.java");
 *		reDir.mkdir();
 *
 *		파일 이동의 예 
 *		File myFile = new File("C:\\Your.java\\my.bin"); 현재 위치
 *		File reFile = new File(reDir, "my.bin); 이동 경로 선택
 *		myfile.renameTo(reFile); 파일이동
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * 
 */


