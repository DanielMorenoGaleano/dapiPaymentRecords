package com.avianca.pagos.rest.dto;

import java.io.Serializable;
import java.util.List;

import net.minidev.json.JSONObject;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.NotNull;

@JsonAutoDetect
@JsonSerialize
public class RequestDTO implements Serializable {
	
    @NotNull
	@JsonProperty(value = "paymentRequests")
    private List<JSONObject> paymentRecords;
    
    
//	private List<RequestRecord> paymentRecords;
//
//	public List<RequestRecord> getPaymentRecords() {
//		return paymentRecords;
//	}
//
//	public void setPaymentRecords(List<RequestRecord> paymentRecords) {
//		this.paymentRecords = paymentRecords;
//	}
	
	public List<JSONObject> getPaymentRecords() {
		return paymentRecords;
	}


	public void setPaymentRecords(List<JSONObject> paymentRecords) {
		this.paymentRecords = paymentRecords;
	}


	@Override
	public String toString() {
		RequestDTO dto = new RequestDTO();
		dto.setPaymentRecords(paymentRecords);
		String jsonp = null;
		try {
			jsonp = new ObjectMapper().writeValueAsString(dto);
//			System.out.println("este es el Dto: \n"+ jsonp);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonp;
	}
	
}
