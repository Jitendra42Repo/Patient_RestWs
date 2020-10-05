# Patient_RestWs: Apache CXF Spring Boot Rest Service

1. Create a Patient rest endpoint using spring boot JAX-RS. Patient has id, first name, last name and isNewComer instance variables.  
2. Consumer should be able to perform CRUD operations. 
3. Handle the excpetion raised in the service layer using JAX-RS mapper.
4. Configure bot XML && JSON support for request and response.
5. Configure the spring security for accessing service endpoints. 

6. Demostrate Asynchronous JAX-RS Endpoint use case.

## Tech Stack:

1. Create Spring starter project in STS and add "cxf spring boot jaxrs", "codehaus jackson" and "spring boot starter security" dependency. 
2. Create REST Endpoint for Patient service:
    I. Create Service Interface and mark it with JAX-RS annotations to create endpoints. @Path @GET, @POST @PathParam and so on.      
    II. Implement the Interface in the implementor class with business logic. Use in memory database for storing patient details.           
    III. Mark the DTO class with JaX-B annotation for XML support. @XmlRootElement, @XmlElement.
    IV. Mark @Consumes and @Produces annotation in the Patient Service Interface. e.g.  @Consumes("application/xml, application/json).
    V. Enable the Jackson support in application.properties file by using "cxf.jaxrs.component-scan=true, 
    cxf.jaxrs.classes-scan-packages=org.codehaus.jackson.jaxrs.            
    VI. Enable sping security with spring.security.username=customer, spring.security.passsword=customer. Create SpingSecurityConfig class that implements
    WebSecurityConfigurerAdapter's (Interface) configure(HttpSecurity) to disable cross site scripting feature.           
    VII. Create a Exception class that implements ExceptionMapper<ServiceException> interface and write "toResponse(ServiceException e)" method to handle the 
    exception in custom way. Note: This is used to handle the "ServiceException" happening in any layer of the service (DA layer, Busineess Layer 
    or Service Layer).          
    
  3. Create another "AsyncPatientService" service that has Asynchronous addPatient endpoint. Use "@Suspended AsyncResponse" as one of the parameter of the service 
  method to enable Asynchronous method.  
    
  3. Testing the Endpoint: Use POSTMAN to test the endpoints.
