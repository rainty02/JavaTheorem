package member;

// 빈즈 클래스 생성
public class Member {

	// 변수는 모두 private 처리
	private String id;
	private String pw;
	private String name;
	
	// **beans 클래스는 기본 생성자 필수
	public Member() {}
	
//	public Member(String name) {}

	// getter
	public String getId() {
		return id;
	}

	// setter
	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
		
	
	
}
