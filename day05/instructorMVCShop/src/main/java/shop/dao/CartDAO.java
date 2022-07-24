package shop.dao;

import java.util.ArrayList;
import java.util.List;

import shop.dto.ProductDTO;

public class CartDAO {
	private List<ProductDTO> list;
	
	private static CartDAO instance = new CartDAO();
	private CartDAO() {
		list = new ArrayList<>();
	}
	public static CartDAO getInstance() {
		return instance;
	}
	
	public void addCart(ProductDTO dto) {
		for(ProductDTO cart : list) {
			if (cart.getPnum() == dto.getPnum()) {
				cart.setPqty(cart.getPqty() + dto.getPqty());
				return;
			}
		}
		list.add(dto);
	}
	
	public List<ProductDTO> listCart(){
		return list;
	}
	
	public void editCart(int pnum, int qty) {
		for(ProductDTO cart : list) {
			if (cart.getPnum() == pnum) {
				if (qty <= 0) {
					deleteCart(pnum);
					return;
				}
				cart.setPqty(qty);
				return;
			}
		}
	}
	
	public void deleteCart(int pnum) {
		for(ProductDTO cart : list) {
			if (cart.getPnum() == pnum) {
				list.remove(cart);
				return;
			}
		}
	}
	
	public void deleteAllCart() {
		list.clear();
	}
}
