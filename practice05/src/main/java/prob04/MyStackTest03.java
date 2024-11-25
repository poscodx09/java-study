package prob04;

public class MyStackTest03 {

	public static void main(String[] args) {
		try {
			// Generic은 컴파일할 때 바뀐다~~~
			MyStack03<String> stack = new MyStack03<>(3);
			stack.push("Hello");
			stack.push("World");
			stack.push("java");
			stack.push(".");

			while (stack.isEmpty() == false) {
				String s = stack.pop();
				System.out.println(s);
			}

			System.out.println("======================================");

			stack = new MyStack03<>(3);
			stack.push("Hello");

			System.out.println(stack.pop());
			System.out.println(stack.pop());

		} catch (MyStackException ex) {
			System.out.println(ex);
		}
	}
}