package com.force.web.async;

import org.springframework.stereotype.Component;

@Component
public class MockQueue {
	private String placeOrder;

	private String completeOrder;

	public String getPlaceOrder() {
		return placeOrder;
	}

	public void setPlaceOrder(String placeOrder) throws InterruptedException {
		new Thread(()->{
			System.out.println("接到下单请求，"+placeOrder);
			this.completeOrder = placeOrder;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.placeOrder = placeOrder;
			System.out.println("下单请求处理完毕，"+placeOrder);
		}).start();
		
	}

	public String getCompleteOrder() {
		return completeOrder;
	}

	public void setCompleteOrder(String completeOrder) {
		this.completeOrder = completeOrder;
	}

}
