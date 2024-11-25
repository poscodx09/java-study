package prob04;

public class MyStack02 {
	private int top;
	private Object[] buffer;

	public MyStack02(int capacity) {
		/* 구현하기 */
		buffer = new Object[capacity];
	}

	public void push(Object s) {
		/* 구현하기 */
		if (top == buffer.length) {
			resize();
		}
		buffer[top++] = s;
	}

	public Object pop() throws MyStackException {
		/* 구현하기 */
		if (isEmpty()) {
			throw new MyStackException("stack is empty");
		}
		Object value = buffer[--top];
		buffer[top] = null;
		return value;
	}

	public boolean isEmpty() {
		/* 구현하기 */
		return top == 0;
	}

	private void resize() {
        Object[] newBuffer = new Object[buffer.length * 2];
        for (int i = 0; i < buffer.length; i++) {
            newBuffer[i] = buffer[i];
        }
        buffer = newBuffer;
	}	
}