package prob02;

public abstract class Bird {
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void fly() {
	}

	public void sing() {
	}
	
    public String toString() {
    	return "이름은 " + name + "입니다.";
    }
}