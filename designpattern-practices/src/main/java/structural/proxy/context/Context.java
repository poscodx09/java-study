package structural.proxy.context;

import structural.proxy.Subject;

class Context {
	private Subject realSubject;
	
	public Context() {
		this(() -> {System.out.println("Subject.doAction called");});
	}
	private Context(Subject subject) {
		realSubject = subject;
	}
	
	Subject getSubject() {
		return realSubject;
	}
	
}
