package prob05;

public class Account {
	private String accountNo;
	private int balance;
	
	public Account(String string) {
		this.accountNo = string;
		this.balance = 0;
		System.out.println(this.accountNo + "계좌가 개설되었습니다.");
	}
	public void save(int i) {
		this.setBalance(this.balance + i);
		System.out.println(this.accountNo + "계좌에 " + i + "만원이 입금되었습니다.");
	}
	public void deposit(int i) {
		this.setBalance(this.balance - i);
		System.out.println(this.accountNo + "계좌에 " + i + "만원이 출금되었습니다.");
	}
	
//	public void printBalance() {
//		System.out.println(this.accountNo + "계좌의 잔고는 " + this.balance + "만원 입니다.");
//	}
	
	public String getAccountNo() {
		return accountNo;
	}
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	
}
