package jiten.restws.com;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import jiten.restws.dto.Patient;

@Path("/patientSrvc")
@Consumes("application/xml,application/json")
@Produces("application/xml, application/json")

public interface PatientService {
	
	@GET 
	@Path("/getAllPatients")
	public List<Patient> getAllPatients();
	
	@GET
	@Path("/patients")
	public Response getPatients(@Context HttpHeaders headers);
	
	@GET
	@Path("/getPatient/{id}")
	public Patient getPatient(@PathParam("id") Integer id) ;
	
	@POST
	@Path("/addPatient")
	public Response addPatient( Patient patient);
	
	@PUT
	@Path("/updatePatient")
	public Response updatePatient( Patient patient);
	
	@DELETE
	@Path("/deletePatient/{id}")
	public Response deletePatient(@PathParam("id")Integer id);
	

}
