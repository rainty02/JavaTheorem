package com.inheritance.practice;

public class InstanceOfMain { // public은 만든 이름과 같은 class의 하나만 사용가능

	public static void main(String[] args) {
		
		Box box1 = new Box();
		PaperBox box2 = new PaperBox();
		GoldPaperBox box3 = new GoldPaperBox();
		
		// intanceof 연산자
		wrapBox(box1);
		wrapBox(box2);
		wrapBox(box3);
		
	}
	
	public static void wrapBox(Box box) { // 메인 메소드에서 바로 사용가능하도록 static 사용
		
		// instanceof 형변환 여부 확인
		// 객체 갯수가 늘어난다면?? ....답없음
		if(box instanceof GoldPaperBox) {
			((GoldPaperBox)box).goldPaperWrap();
		} else if(box instanceof PaperBox) {
			((PaperBox)box).paperWrap();
		} else {
			box.simpleWrap();
		}
		
		// 오버라이딩
		// 코드량도 줄이고 효율적으로 사용
		box.Wrap();
	}
}

class Box {
	public void simpleWrap() {
		System.out.println("SimpleWrap");
	}
	public void Wrap() {
		System.out.println("SimpleWrap");
	}
}

class PaperBox extends Box {
	public void paperWrap() {
		System.out.println("PaperWrap");
	}
	public void Wrap() {
		System.out.println("Override : PaperWrap");
	}
}

class GoldPaperBox extends PaperBox	{
	public void goldPaperWrap() {
		System.out.println("GoldPaperWrap");
	}
	public void Wrap() {
		System.out.println("Override : GoldPaperWrap");
	}
}