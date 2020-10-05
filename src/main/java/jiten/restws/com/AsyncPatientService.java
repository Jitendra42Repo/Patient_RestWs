package jiten.restws.com;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

import jiten.restws.dto.Patient;

@Path("/asyncPatient")
public interface AsyncPatientService {
	
	@POST
	@Path("/addPatient")
	public void addPatient(@Suspended AsyncResponse response, Patient patient); 
	

}
