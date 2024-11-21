package chapter03;

public class GoodsApp {
	
	public static void main(String[] args) {
		Goods goods = new Goods();
//		goods.name = "nikon";
		// goods.name = new String("nikon)"; 이게 보통 맞다고 함
//		goods.price = 40000;
//		goods.countSold = 10;
//		goods.countStock = 20;
		goods.setName("nikon");
		goods.setPrice(40000);
		goods.setCountSold(3);
		goods.setCountStock(2);
		
		
//		System.out.println("상품이름: " + goods.getName()+
//				", 가격: " + goods.getPrice() +
//				", 판매량: " + goods.getCountSold() +
//				", 재고: " + goods.getCountStock());
		
		System.out.println(goods.getClass());
		
		goods.printInfo();
		
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		System.out.println(Goods.countOfGoods);
		
		goods.setPrice(400000);
		System.out.println(goods.calcDiscountPrice(0.5f));
	}

}
