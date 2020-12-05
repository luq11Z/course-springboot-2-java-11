package com.lucaslearning.course.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code; //codigo do tipo enumerado
	
	//construtor
	private OrderStatus(int code) {
		this.code = code;
	}
	
	//metodo publico para do construtor
	public int getCode() {
		return code;
	}
	
	//converter valor numerico para tipo enumerado
	//vai retornar um objeto do tipo OrderStatus e recebe um codigo (int)
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code!");
	}
	
}
