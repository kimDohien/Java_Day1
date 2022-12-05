package exampleShopping;

import java.util.List;
import java.util.Scanner;

public class ProductServiceImp implements ProductService {

	@Override //등록
	public boolean insertProduct(List<Product> productList, Product product) {
		if(productList == null || product == null)//상품이 비어있다면 return false
			return false;
		if(productList.contains(product)) { //상품이 있는지 없는지 확인해서 있으면 return false
		return false;
		}
		productList.add(product); //아니라면 저장
		return true;
	}

	
	@Override //수정
	public boolean updateProduct(List<Product> productList,int index , Product product) {
		if(productList ==null || productList.size()==0 || index <0 || product ==null)
		return false;
		productList.set(index, product);
		return true;
	}

	@Override
	public boolean deleteProduct(List<Product> productList, Product product) {
		//매개변수 예외체크
		if(productList ==null || productList.size() ==0 ||product == null)
			return false;
		
		return productList.remove(product);
	}

	@Override
	public Product getProduct(List<Product> productList, int index) {
		//매개변수 예외처리
		if(productList == null || index<0 || productList.size()<= index)
			return null;
		
		return productList.get(index);
	}

	@Override
	public boolean productStock(Product product, int amount) {
		//판매시 판매 수량은 재고량보다 클수 없다는 조건설정
		if(amount<0 && product.getAmount()< -amount) {
			System.out.println("!재고량이 부족합니다!");
				return false;
			}
		product.addAmount(amount);
		return true;
	}

	@Override
	public Product inputProduct() {
		Scanner scan= new Scanner(System.in);
		System.out.println("분류 : ");
		String type = scan.nextLine();
		System.out.println("제품명 : ");
		String title = scan.nextLine();
		System.out.println("구매가 : ");
		int buyPrice = scan.nextInt();
		System.out.println("판매가 : ");
		int sellPrice = scan.nextInt();
		scan.nextLine();
		if(buyPrice>sellPrice) //마진이 남아야 하기때문에 조건을 정해준거임
			return null;
		return new Product(type,title,buyPrice, sellPrice);
	}


	@Override
	public Product getProduct(List<Product> productList, Product product) {
		int index = productList.indexOf(product);
		if(index<0)
			return null;
		return productList.get(index);
	}

}
