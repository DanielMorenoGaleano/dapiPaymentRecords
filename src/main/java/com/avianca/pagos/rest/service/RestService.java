package com.avianca.pagos.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.avianca.pagos.rest.dto.RequestDTO;


@Path("/")
public interface RestService {

    @POST
    @Consumes(value = { MediaType.APPLICATION_JSON })
    @Produces(value = { MediaType.APPLICATION_JSON })
    public Response getMethod(RequestDTO request);
}
