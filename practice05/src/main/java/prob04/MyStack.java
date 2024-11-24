package prob04;

public class MyStack {
	private int top;
	private String[] buffer;

	public MyStack(int capacity) {
		/* 구현하기 */
		buffer = new String[capacity];
	}

	public void push(String s) {
		/* 구현하기 */
		if (top == buffer.length) {
			resize();
		}
		buffer[top++] = s;
	}

	public String pop() throws MyStackException {
		/* 구현하기 */
		if (isEmpty()) {
			throw new MyStackException("stack is empty");
		}
		String value = buffer[--top];
		buffer[top] = null;
		return value;
	}

	public boolean isEmpty() {
		/* 구현하기 */
		return top == 0;
	}

	private void resize() {
        String[] newBuffer = new String[buffer.length * 2];
        for (int i = 0; i < buffer.length; i++) {
            newBuffer[i] = buffer[i];
        }
        buffer = newBuffer;
	}	
}