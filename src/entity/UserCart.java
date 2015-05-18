package entity;
/*
 * 用户购物车类
*/
public class UserCart {

	private int pid; // 商品编号
	private String name; // 商品名称
	private int gross; // 价格
	private String picture; // 商品图片
	private int count;
	private String city;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getGross() {
		return gross;
	}
	public void setGross(int gross) {
		this.gross = gross;
	}
	
	

}
