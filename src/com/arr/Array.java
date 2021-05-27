package com.arr;

public class Array {

	public static void main(String[] args) {
		
//		배열은 같은 *타입의과 같은 *속성의 변수 집합
//		각 요소(index)는 서로 연속적이므로 배열은 for문과 함께 사용 
		
//		1차원배열
//		객체를 다루는 배열
//		2차원배열
//		1차원배열의 집합
		
		//배열 선언
		//arrInt(배열이름)는 배열의 참조값주소을 저장, 해당 값이 아님
		int[] arrInt = new int[3]; // 생성하려는 갯수 입력
		
		//배열 초기화
		//인덱스 0~n-1까지
		//arrInt2 = {1, 2, 3}; 불가
		arrInt[0] = 1;
		arrInt[1] = 2;
		arrInt[2] = 3;
		
		//선언과 초기화를 동시에
		int[] arrInt2 = {1, 2, 3};
		String[] arrStr = {"A", "B", "C"};		
		
		//for문
		//실제 값을 가져와 사용하므로  배열에 값들을 수정할 수 있음
		for(int inx=0; inx<arrInt.length; inx++) {
			System.out.println("for : arrInt[" + inx + "] = " + arrInt[inx]);
		}
		
		for(int inx=0; inx<arrInt.length; inx++) {
			arrInt[inx]++;
		}
		
		for(int inx=0; inx<arrInt.length; inx++) {
			System.out.println("for : arrInt[" + inx + "] = " + arrInt[inx]);
		}		
		
		
		//for each문
		//배열의 일부가 아닌 전체를 참조할 때 사용
		for(int inx : arrInt2) {
			System.out.println("for each : arrInt2[" + (inx-1) + "] = " + inx);
		}		
		//배열의 값을 임의의 값 i에 대입시켜 사용하므로 실제 배열에는 반영되지 않아 값의 참조목적으로 사용
		//만약 반영하고 싶다면 해당 주소값을 통한 인스턴스 접근가능
		//ex: inx.num++ (해당클래스로 접근)
		for(int inx : arrInt2) {
			inx++;
		}		
		
		for(int inx : arrInt2) {
			System.out.println("for each : arrInt2[" + (inx-1) + "] = " + inx);
		}
		
		//자리바꿈
		int[] ball = new int[45];
		for(int inx=0; inx<ball.length; inx++) {
			ball[inx] = inx+1;
		}
		int temp = 0;
		int j = 0;
		for(int i=0; i<100; i++) {
			j = (int)(Math.random()*45);
			temp = ball[0];
			ball[0] = ball[j];
			ball[j] = temp;
		}
		for(int i : ball) {
			System.out.println(i);
		}
		
	}
}