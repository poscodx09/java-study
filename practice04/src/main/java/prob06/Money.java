package prob06;

public class Money {
	private int amount;
	
	public Money(int i) {
		this.amount = i;
	}

	public Object add(Money money) {
		Money m = new Money(this.amount+money.getAmount());
		return m;
	}
	
	public Object minus(Money money) {
		Money m = new Money(this.amount-money.getAmount());
		return m;
	}
	
	public Object multiply(Money money) {
		Money m = new Money(this.amount*money.getAmount());
		return m;
	}
	
	public Object divide(Money money) {
		Money m = new Money(this.amount/money.getAmount());
		return m;
	}
	
	public boolean equals(Object object) {
		if (object instanceof Money) {
			if (((Money) object).getAmount() == this.amount) {
				return true;
			}
		}
		System.out.println();
		return false;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
	
	
}
