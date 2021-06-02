package com.file_iostream.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ObjectSerializabe {

	public static void main(String[] args) {
				
		try {
			// 인스턴스 저장
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Object.ser"));
			
			out.writeObject(new Circle(1, 2, 3.4));
			out.writeObject(new Circle(3, 5, 7.9));
			out.writeObject("Hello");
			
			// 하나씩 직렬화할 필요없이 일괄적으로  직렬화
			ArrayList<Circle> list = new ArrayList<>();
			list.add(new Circle(1, 2, 1.4));
			list.add(new Circle(5, 6, 8.4));
			list.add(new Circle(4, 3, 5.4));
			list.add(new Circle(7, 7, 3.2));
			list.add(new Circle(3, 8, 5.4));
			out.writeObject(list);
			
			out.close();
			
			System.out.println("인스턴스 저장완료");
		
			// 인스턴스 복원
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.ser"));
			
			
			// 복원 순서는 저장순서에 맞게 복원
			Circle c1 = (Circle) in.readObject();
			Circle c2 = (Circle) in.readObject();
			String str = (String) in.readObject();
			System.out.println();
			
			
			ArrayList<Circle> list2 = (ArrayList<Circle>) in.readObject();
			for (Circle circle : list2) {
				System.out.println(circle);
			}
			
			System.out.println("복원된 인스턴스의 데이터 출력");
			
			c1.showData();
			c2.showData();
			System.out.println(str);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

class Circle implements Serializable {
	
	// implements Serializable - Circle 클래스는 직렬화 대상임을 의미
	// 작성하지 않는다면 직렬화 불가
	
	int x;
	int y;
	transient double r;
	// 직렬화 제외, 디폴트값 출력

	public Circle(int x, int y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	public void showData() {
		System.out.println("원점["+x+", "+y+"]");
		System.out.println("반지름은 "+r);
		System.out.println();
	}

	@Override
	public String toString() {
		return "Circle [x=" + x + ", y=" + y + ", r=" + r + "]";
	}
	
	
}