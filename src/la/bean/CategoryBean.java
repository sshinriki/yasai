package la.bean;

import java.io.Serializable;

public class CategoryBean implements Serializable{
	private int code;
	private String name;


//コンストラクタ
	public CategoryBean(){

	}

	public CategoryBean(int code,String name){
		this.code=code;
		this.name=name;
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


}