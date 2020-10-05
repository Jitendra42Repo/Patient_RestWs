package jiten.restws.com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.apache.cxf.feature.Features;
import org.springframework.stereotype.Service;

import jiten.restws.Exception.ServiceException;
import jiten.restws.dto.Patient;

@Features(features = "org.apache.cxf.feature.LoggingFeature")
@Service
public class PatientServiceImpl implements PatientService {
	
	private Map<Integer, Patient> patients = new HashMap<>();
	private Integer id = 0;
	
	public PatientServiceImpl() {
		init();
		
	}
	
	private void init() {
		Patient patient = new Patient();
		patient.setfName("Bob");
		patient.setlName("Dylan");
		patient.setNewComer(false);
		patient.setId(++this.id);
		this.patients.put(patient.getId(), patient);
		
		/*patient.setfName("Jimmy");
		patient.setlName("Veder");
		patient.setNewComer(false);
		patient.setId(++this.id);
		this.patients.put(patient.getId(), patient); */
		
	}

	@Override
	public List<Patient> getAllPatients() {
		Collection<Patient> values = this.patients.values();
		List<Patient> patients = new ArrayList<>(values);
		
		return patients;
	}

	@Override
	public Patient getPatient(Integer paramId)  {
		Patient patient = this.patients.get(paramId);
		if(null == patient) {
			throw new ServiceException();
		}
		return patient;
	}

	@Override
	public Response addPatient(Patient patient) {
		
		if(null == patient.getfName() || null == patient.getlName() ) {
			return Response.status(422).entity("Patient details missing.").build();
		}
		
		Collection<Patient> values = this.patients.values();
		List<Patient> listOfPatients = new ArrayList<>(values);
		for (Patient patientValue : listOfPatients) {
			boolean equals = patientValue.equals(patient);
			if(equals) {
				System.out.println("\n\n"+patient.toString()+" \nalready exists with id.\n\n");
				return Response.status(409).entity("Patient already exists,").build();
			}
		}
		
		patient.setId(++this.id);
		this.patients.put(patient.getId(), patient);
		System.out.println("\n\n"+patient.toString()+" \nis added to patients list with id: "+this.id+"\n\n");
		return Response.status(200).entity("Patient is added.").build();
	}

	@Override
	public Response updatePatient(Patient patient) {
		
		
		if(this.patients.containsKey(patient.getId())){
			this.patients.replace(patient.getId(), patient);
			return Response.status(200).entity("Patient record updated successfully !").build();
		}
		else {
			return Response.status(404).entity("Patient record doesn't exists !").build();
		}
		
	}

	@Override
	public Response deletePatient(Integer id) {
		if(this.patients.containsKey(id)) {
			this.patients.remove(id);
			return Response.status(200).entity("Patient record deleted succesfully !").build();
		}
		return Response.status(404).entity("Patient record does not exists !").build();
	}

	@Override
	public Response getPatients(HttpHeaders headers) {
		MultivaluedMap<String, String> allHeaders = headers.getRequestHeaders();
		Set<String> headerskey = allHeaders.keySet();
		for (String key : headerskey) {
			System.out.println("***** Header *****");
			System.out.println(key);
			System.out.println(headers.getHeaderString(key));
		}
		System.out.println();
		Map<String, Cookie> cookies = headers.getCookies();
		Set<String> cookieKeys = cookies.keySet();
		for (String key : cookieKeys) {
			System.out.println("***** Cookie *****");
			System.out.println(key);
			System.out.println(cookies.get(key).getValue());
		}
		
		return Response.status(204).build();
	}

	

	



}
