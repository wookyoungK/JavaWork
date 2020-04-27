package collection03;

import com.lec.java.collection03.Score;
	//id,name,kor,eng,mat
public class Student {
	private int kor;
	private String name;
	private int id;
	private int eng;
	private int math;
	
	public Student() {}

	public Student(int kor, String name, int id, int eng, int math) {

		this.kor = kor;
		this.name = name;
		this.id = id;
		this.eng = eng;
		this.math = math;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	@Override
		public String toString() {
		String str ="";
		System.out.println(name);
		System.out.println(id);
		System.out.println(eng);
		System.out.println(math);
		System.out.println(kor);

				
			return str;
		}
	

	
}
