package jiten.restws.com;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.container.AsyncResponse;

import org.springframework.stereotype.Service;

import jiten.restws.dto.Patient;

@Service
public class AsyncPatientServiceImpl implements AsyncPatientService{

	private Map<Integer, Patient> patientDB;
	private Integer Id = 123;
	
	private void init() {
		this.patientDB = new HashMap<Integer, Patient>();
		Patient patient = new Patient();
		patient.setId(this.Id);
		patient.setfName("Atlas");
		patient.setlName("Hooper");
		patient.setNewComer(false);
		
		patientDB.put(this.Id, patient);
		
		Patient patient2 = new Patient();
		patient2.setId(++this.Id);
		patient2.setfName("Dough");
		patient2.setlName("Jefferson");
		patient2.setNewComer(false);
		
		patientDB.put(this.Id, patient);
	}
	
	public AsyncPatientServiceImpl() {
		init();
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void addPatient(AsyncResponse asyncResponse, Patient patient) {
		
		Thread thread = new Thread() {
			public void run() {
				//String response = "Hi from Server !";
				asyncResponse.resume(true);
			}
		};
		try {
			thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.start();
		
	}

}
