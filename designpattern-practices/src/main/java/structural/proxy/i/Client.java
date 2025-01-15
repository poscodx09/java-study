package structural.proxy.i;

import structural.proxy.Subject;
//import structural.proxy.context.Context;
import structural.proxy.context.Proxy;

public class Client {
	
	public static void main(String[] args) {
//		Context ctx = new Context();
//		Subject subject = ctx.getSubject();
//		subject.doAction();
		
		Subject subject = new Proxy();
		subject.doAction();
	}


}
