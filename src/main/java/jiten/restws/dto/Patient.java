package jiten.restws.dto;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Patient")
public class Patient {
	
	@XmlElement(name="firstName")
	private String fName;
	@XmlElement(name="lastName")
	private String lName;
	@XmlElement(name="isNewComer")
	private boolean newComer;
	@XmlElement(name="patientId")
	private Integer id;
	
	
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public boolean isNewComer() {
		return newComer;
	}

	public void setNewComer(boolean newComer) {
		this.newComer = newComer;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		
		return "Patient Details. fName: "+getfName()+" lName: "+getlName()+" isNewComer: "+isNewComer()+
				" id: "+getId();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		else if(null == obj || obj.getClass() != this.getClass()) {
			return false;
		}
		Patient obj1 = (Patient)obj;
		
		return (this.getfName().equals(obj1.getfName()) && this.getlName().equals(obj1.getlName()) && 
				this.newComer == obj1.isNewComer() );
		
	}

	@Override
	public int hashCode() {
		return this.getId();
	}
	
	


}
