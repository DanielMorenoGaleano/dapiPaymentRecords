package com.avianca.pagos.rest.processor;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component("replaceLastName")
public class ReplaceLastName implements Processor {
	
	
    public void process(Exchange exchange) throws Exception {
		String endpoint=exchange.getIn().getHeader("endpointRecords").toString();
		String urlrecords=exchange.getIn().getHeader("endpointRecordsPayment").toString();
		String orderId=exchange.getIn().getHeader("orderId").toString();
		String lastName=exchange.getIn().getHeader("lastName").toString().replace(" ", "%20");
		
		String url = endpoint+orderId+urlrecords+lastName;
		
		exchange.getIn().setHeader("url.record", url);
    	
    }  

}
