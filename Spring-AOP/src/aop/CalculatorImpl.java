package aop;

public class CalculatorImpl implements Calculator {
	// 인터페이스에서 정의되었던 추상메서드
	@Override
	public long factorial(long num) {
		// 현재 시간 기준에서 1970년 10월 1일 0시 0분 0초를 기준으로 밀리 초 값을 long타입으로 계산해서 반환
		//long start = System.currentTimeMillis();
		long result = 1;
		for (long i = 1; i <= num; i++) {
			result *= i;
		}
		//long end = System.currentTimeMillis();
		// 실행 시간은 end-start 값으로 계산
		//System.out.println("factorial(" + num + ") 실행시간 :" + (end - start));
		return result;
	}
}
