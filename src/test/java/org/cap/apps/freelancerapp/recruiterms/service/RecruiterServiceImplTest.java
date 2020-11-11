package org.cap.apps.freelancerapp.recruiterms.service;

import org.cap.apps.freelancerapp.exceptions.InvalidArgumentException;
import org.cap.apps.freelancerapp.exceptions.InvalidRecruiterNameException;
import org.cap.apps.freelancerapp.exceptions.RecruiterNotFoundException;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(RecruiterServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RecruiterServiceImplTest {
	
	@Autowired
	RecruiterServiceImpl service;

	@Autowired
	private EntityManager entityManager;

	/* testcase for saving the data */

	@Test
	public void testSave_1() {
		String firstName = "Suraj", lastName = "Patil", pass = "root";
		Recruiter recruiter = new Recruiter(firstName, lastName, pass);
		recruiter = service.save(recruiter);
		TypedQuery<Recruiter> query = entityManager.createQuery("from Recruiter", Recruiter.class);
		List<Recruiter> list = query.getResultList();
		Assertions.assertEquals(1, list.size());
		Recruiter stored = list.get(0);
		Assertions.assertEquals(firstName, stored.getFirstName());
		Assertions.assertEquals(lastName, stored.getLastName());
		Assertions.assertEquals(pass, stored.getPassword());
	}
	
	

	/* Testcase to find the data by id */
	@Test
	public void testFindById_1() {
		String firstName = "Suraj";
		String lastName = "Patil";
		String pass = "root";
		Recruiter recruiter = new Recruiter(firstName, lastName, pass);
		entityManager.persist(recruiter);
		Long id = recruiter.getId();
		Recruiter actual = service.findById(id);
		Assertions.assertEquals(id, actual.getId());
		Assertions.assertEquals(firstName, actual.getFirstName());
		Assertions.assertEquals(lastName, actual.getLastName());

	}
	
	/* Testcase to check that recruiter data can be fetched by id */
	@Test
	public void testFindById_2() {
		Executable executable = new Executable() {
			@Override
			public void execute() throws Throwable {
				service.findById(1L);
			}
		};
		Assertions.assertThrows(RecruiterNotFoundException.class, executable);

	}

	 /**
     * scenario: recruiter argument is null
     */
	@Test
	public void testSave_2() {
	
	  Recruiter recruiter=null;
      Executable executable=()-> service.save(recruiter);
      Assertions.assertThrows(InvalidArgumentException.class,executable);

}
	
	 /**
     * scenario: when firstName is empty
     */
    @Test
    public void testSave_3(){
        String firstName="", lastName="Patil", pass = "root";
        Recruiter recruiter=new Recruiter(firstName,lastName,pass);
        Executable executable=()-> service.save(recruiter);
        Assertions.assertThrows(InvalidRecruiterNameException.class,executable);
    }
    
    /**
     * scenario: when lastName is empty
     */
    @Test
    public void testSave_4(){
        String firstName="Suraj", lastName="", pass = "root";
        Recruiter recruiter=new Recruiter(firstName,lastName,pass);
        Executable executable=()-> service.save(recruiter);
        Assertions.assertThrows(InvalidRecruiterNameException.class,executable);
    }
}



