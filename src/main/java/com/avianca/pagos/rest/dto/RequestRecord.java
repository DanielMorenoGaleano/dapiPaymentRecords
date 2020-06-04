package com.avianca.pagos.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestRecord {
	
	@JsonProperty(value = "paymentMethod")
	private PaymentMethod paymentMethod ;

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	

}
