package exampleShopping;

import java.util.List;

public class ProductController {
	private ProductService ps = new ProductServiceImp();
	private List<Product> productList;
	

	public ProductController(List<Product> productList,ProductService ps) {
		this.productList = productList;
	}

	public void insertProduct() { //제품 등록
		//새제품 정보 입력
		Product product = ps.inputProduct();
		//제품리스트에 새 정보 입력등록;
		if(ps.insertProduct(productList, product)) {
			System.out.println("[제품을 등록했습니다]");
		}else {
			System.out.println("!제품 등록에 실패했습니다!");
		}
	
	}

	public void updateProduct() {//제품 수정(분류랑 제품명 써서 똑같으면 수정)
		//수정할 제품 내용 입력
		Product newProduct = ps.inputProduct();//inputProduct는 productService에 객체반환 메소드 적어둠
		//기존 제품 정보를 가져온다
		int index = productList.indexOf(newProduct);
//		System.out.println(index); //확인용
		//제품 정보 수정(판매가,구매가 밖에 수정안됨)
		if(ps.updateProduct(productList, index, newProduct)) {
			System.out.println("[제품 정보가 수정되었습니다]");
		}else {
			System.out.println("!제품 수정에 실패했습니다!");
		}
	}

	public void deleteProduct() {//제품 삭제
		//삭제할 제품 내용입력(분류,제품명만 필요..판매가,구매가 0으로 입력)
		Product deleteProduct = ps.inputProduct();
		
		//삭제할 제품 정보를 가져옵니다
		int index = productList.indexOf(deleteProduct);
		Product product = ps.getProduct(productList, index);
		
		//제품을 리스트에서 삭제
		if(ps.deleteProduct(productList, product)) {
			System.out.println("[제품이 삭제 되었습니다]");
		}else {
			System.out.println("!삭제 실패!");
		}
		
	}

	
}
