package org.cap.apps.freelancerapp.adminms.service;


import org.cap.apps.freelancerapp.adminms.entities.Admin;
import org.cap.apps.freelancerapp.exceptions.AdminNotFoundException;
import org.cap.apps.freelancerapp.exceptions.InvalidAdminNameException;
import org.cap.apps.freelancerapp.exceptions.InvalidArgumentException;
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
@Import(AdminServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AdminServiceImplTest {

	@Autowired
	IAdminService service;
	
	@Autowired
	private EntityManager entityManager;

	/* Testcase for saving the data of admin */
	@Test
	public void testSave_1() {
		String firstName = "Shreya", lastName = "Khandait", pass = "root";
		Admin admin = new Admin(firstName, lastName, pass);
		admin = service.save(admin);
		TypedQuery<Admin> query = entityManager.createQuery("from Admin", Admin.class);
		List<Admin> list = query.getResultList();
		Assertions.assertEquals(1, list.size());
		Admin stored = list.get(0);
		Assertions.assertEquals(firstName, stored.getFirstName());
		Assertions.assertEquals(lastName, stored.getLastName());
		Assertions.assertEquals(pass, stored.getPassword());
	}

	/* Testcase to find the data by id */
	@Test
	public void testFindById_1() {
		String firstName = "Shreya";
		String lastName = "Khandait";
		String pass = "root";
		Admin admin = new Admin(firstName, lastName, pass);
		entityManager.persist(admin);
		Long id = admin.getId();
		Admin actual = service.findById(id);
		Assertions.assertEquals(id, actual.getId());
		Assertions.assertEquals(firstName, actual.getFirstName());
		Assertions.assertEquals(lastName, actual.getLastName());

	}

	/* Testcase to check that admin data can be fetched by id */
	@Test
	public void testFindById_2() {
		Executable executable = new Executable() {
			@Override
			public void execute() throws Throwable {
				service.findById(11L);
			}
		};
		Assertions.assertThrows(AdminNotFoundException.class, executable);

	}

	 /**
     * scenario: admin argument is null
     */
	@Test
	public void testSave_2() {
	
	  Admin admin=null;
      Executable executable=()-> service.save(admin);
      Assertions.assertThrows(InvalidArgumentException.class,executable);

}
	
	 /**
     * scenario: when firstName is empty
     */
    @Test
    public void testSave_3(){
        String firstName="", lastName="Khandait", pass = "root";
        Admin admin=new Admin(firstName,lastName,pass);
        Executable executable=()-> service.save(admin);
        Assertions.assertThrows(InvalidAdminNameException.class,executable);
    }
    
    /**
     * scenario: when lastName is empty
     */
    @Test
    public void testSave_4(){
        String firstName="Shreya", lastName="", pass = "root";
        Admin admin=new Admin(firstName,lastName,pass);
        Executable executable=()-> service.save(admin);
        Assertions.assertThrows(InvalidAdminNameException.class,executable);
    }
}
