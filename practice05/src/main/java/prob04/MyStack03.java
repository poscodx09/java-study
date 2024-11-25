package prob04;

public class MyStack03<T> {
	private int top;
	private T[] buffer;

	@SuppressWarnings("unchecked")
	public MyStack03(int capacity) {
		/* 구현하기 */
		buffer = (T[]) new Object[capacity];
	}

	public void push(T s) {
		/* 구현하기 */
		if (top == buffer.length) {
			resize();
		}
		buffer[top++] = s;
	}

	public T pop() throws MyStackException {
		/* 구현하기 */
		if (isEmpty()) {
			throw new MyStackException("stack is empty");
		}
		T value = buffer[--top];
		buffer[top] = null;
		return value;
	}

	public boolean isEmpty() {
		/* 구현하기 */
		return top == 0;
	}

	@SuppressWarnings("unchecked")
	private void resize() {
		T[] newBuffer = (T[]) new Object[buffer.length * 2];
        for (int i = 0; i < buffer.length; i++) {
            newBuffer[i] = buffer[i];
        }
        buffer = newBuffer;
	}	
}