package tv;

public class TV {
	private int channel;
	private int volume;
	private boolean power;
	
	public TV(int i, int j, boolean b) {
		this.channel = i;
		this.volume = j;
		this.power = b;
	}

	
	public int getChannel() {
		return channel;
	}
	public int getVolume() {
		return volume;
	}
	public boolean isPower() {
		return power;
	}
	
	public void status() {
		System.out.println("TV[channel="+ channel + 
				", volume=" + volume + 
				", power=" + (power ? "on" : "off") + "]");
		
	}
	
	public void power(boolean b) {
		this.power = b;	
	}
	
	public void volume(boolean b) {
		if (b) {
			this.volume++;
		}
		else {
			this.volume--;
		}
		if (this.volume < 0) {
			this.volume = 100;
		}
		this.volume = this.volume % 101;
		
	}
	
	public void volume(int i) {
		if (i > 100) {
			this.volume = 0;
		}
		if (i < 0) {
			this.volume = 100;
		}
	}
	public void channel(int i) {
		if (i > 255) {
			this.channel = 0;
		}
		else if (i < 1) {
			this.channel = 255;
		}
		else {
			this.channel = i;
		}

	}
	public void channel(boolean b) {
		if (b) {
			this.channel++;
		}
		else {
			this.channel--;
		}
		
		this.channel = this.channel % 255;
		
//		if (this.channel < 1) {
//			this.channel = 255;
//		}
//		
//		if (this.channel > 255) {
//			this.channel = 0;
//		}
	}
	
	

}
