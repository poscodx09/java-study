package chapter03;
import mypackage.Goods2;

public class DiscountGoods2 extends Goods2 {

	// 기본 int, double로 보기 때문에 다른 타입 명시해줘야함
	long l = 1234567890L;
	float discountRate = 0.5f;
	
	public float getDiscountPrice() {
		return discountRate * price;
	}
		

}
