package com.avianca.pagos.rest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PaymentMethod {
		
	@JsonProperty(value = "paymentType")
	private String paymentType;
	
	@JsonProperty(value = "externalPaymentRecordId")
	private String externalPaymentRecordId;
	
	@JsonProperty(value = "id")
	private String id ; 
	
	@JsonProperty(value = "parameters")
	private List<ParameterRequest> parameters;

	public String getPaymentType() {
	return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;		
	}
	
	
	public String getExternalPaymentRecordId() {
		return externalPaymentRecordId;
	}

	public void setExternalPaymentRecordId(String externalPaymentRecordId) {
		this.externalPaymentRecordId = externalPaymentRecordId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ParameterRequest> getParameters() {
		return parameters;
	}

	public void setParameters(List<ParameterRequest> parameters) {
		this.parameters = parameters;
	}
	
	
}
