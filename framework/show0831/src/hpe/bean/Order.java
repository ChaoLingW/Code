package hpe.bean;

import java.util.List;

public class Order {
	
	private String orderId;
	List<String> list;
	
	
	public Order() {
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	
	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", list=" + list + "]";
	}

}
