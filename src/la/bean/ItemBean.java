package la.bean;


import java.io.Serializable;


public class ItemBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int code;
	private String name;
	private int price;
	private String img;
	private int stock;
	private String detail;
	private int quantity;
	/**
	 * @param code
	 * @param name
	 * @param price
	 * @param img
	 * @param stock
	 * @param detail
	 * @param quantity
	 */
//コンストラクタ
//すべてのフィールド
	public ItemBean(int code, String name, int price, String img, int stock,
			String detail, int quantity) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.img = img;
		this.stock = stock;
		this.detail = detail;
		this.quantity = quantity;
	}
//商品
	public ItemBean(int code, String name, int price, String img, int stock,
			String detail) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.img = img;
		this.stock = stock;
		this.detail = detail;
	}
	public ItemBean(){

	}
//セッターゲッター
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

