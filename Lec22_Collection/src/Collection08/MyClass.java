package Collection08;


public class MyClass {
	private int id;
	private String name;
	
	public MyClass() {}

	public MyClass(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.id;
	}@Override
	public boolean equals(Object obj) {
		MyClass other = (MyClass)obj;
		boolean result =(this.id ==other.id)&&(this.name.equalsIgnoreCase(name)) ;
		return result; //equals -> equalsIgnore 하면 대소문자 구분 x
	}
	@Override
	public String toString() {
		return "학번: "+id+"\n 이름: "+name;
	}
}
