package com.avianca.pagos.test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avianca.pagos.rest.dto.ParameterRequest;
import com.avianca.pagos.rest.dto.PaymentMethod;
import com.avianca.pagos.rest.dto.RequestDTO;
import com.avianca.pagos.rest.dto.RequestRecord;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import net.minidev.json.JSONObject;

/**
 * 
 * @author Assert Solutions S.A.S <info@assertsolutions.com> <br/>
 *         Date: 9/04/2018 9:17:11 a.m.
 *
 */
public class dapipaymentrecordsTest extends CamelSpringTestSupport {

	private static final String PROPERTIES_FILE_DIR = "src/test/resources/";
	private static Properties testProperties = new Properties();
	
	@Test
	public void testRoute() throws Exception {
		final String fromRoute = "direct:fromRoute";
		byte[] request = Files.readAllBytes(Paths.get(PROPERTIES_FILE_DIR + "requestRecord.json"));
		context.getRouteDefinition("restServerRoute").adviceWith(context, new AdviceWithRouteBuilder() {
			@Override
			public void configure() throws Exception {
				replaceFromWith(fromRoute);
				weaveAddLast().log("Finishing the unit test of the route ").to("mock://endroute");
			}
		});
		context.start();
		// Agregamos un mock endpoint
		
		MockEndpoint mockEndpoint = getMockEndpoint("mock://endroute");
		mockEndpoint.expectedMinimumMessageCount(1);
		RequestDTO dto = new RequestDTO();
		RequestRecord req = new RequestRecord();
		List<RequestRecord> requestRecord = new ArrayList<>();	
		List<ParameterRequest> paymentM=new ArrayList<>();
		PaymentMethod payment = new PaymentMethod();
		ParameterRequest paramR = new ParameterRequest();
	
		//records ExternalPayment
//		payment.setExternalPaymentRecordId("CCCA456789XXXXXX0045");		
//		payment.setPaymentType("ExternalPayment");
		
		//records CustomPayment
//		payment.setPaymentType("CustomPayment");
//		payment.setId("CASH");
		
		
		//records CustomPaymentList
//		paramR.setKey("additionalInput");
//		paramR.setValue("76352883");
//		payment.setParameters(paymentM);
//		payment.setPaymentType("CustomPayment");
//		payment.setId("FT");
//		paymentM.add(paramR);
		
		
		//Validación necesaria Records
		req.setPaymentMethod(payment);
		requestRecord.add(req);
//		json = new ObjectMapper().writeValueAsString(request);
//		dto = gson.fromJson(new String(request), RequestDTO.class);
//		System.out.println("este es el JSON: "+json);
//		System.out.println("este es el DTO: "+dto);
//		
//		dto.setPaymentRecords();
		Map<String, Object> map = new HashMap<>();
		map.put("orderId", "JCHOVL");
		map.put("lastName", "Perez A");		
		map.put("Auth", "489mwN7heGpdQuWgzGx0snssqpeC");
		template.sendBodyAndHeaders(fromRoute, request, map);

		mockEndpoint.assertIsSatisfied(2000L);
	}

	/**
	 * Carga del archivo de propiedades para los Test Unitarios
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void init() throws Exception {
		testProperties.load(dapipaymentrecordsTest.class.getResourceAsStream("/dapipaymentrecords.properties"));
	}

	@BeforeClass
	public static void setUpProperties() throws Exception {
		System.setProperty("karaf.home", PROPERTIES_FILE_DIR);
		System.setProperty("project.artifactId", "Test-Maven-Artifact");
	}

	@Override
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml", "META-INF/spring/properties-beans.xml");
	}

}
