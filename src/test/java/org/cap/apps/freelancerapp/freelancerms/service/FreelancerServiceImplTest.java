package org.cap.apps.freelancerapp.freelancerms.service;

import org.cap.apps.freelancerapp.exceptions.FreelancerNotFoundException;
import org.cap.apps.freelancerapp.exceptions.InvalidArgumentException;
import org.cap.apps.freelancerapp.exceptions.InvalidFreelancerNameException;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
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

@ExtendWith({ SpringExtension.class })
@DataJpaTest
@Import(FreelancerServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FreelancerServiceImplTest {

	@Autowired
	IFreelancerService service;

	@Autowired
	EntityManager entityManager;

	/* Testcase1 for saving the data */
	@Test
	public void testSave_1() {
		String firstName = "Dolly", lastName = "Sharma", pass = "root";
		Freelancer freelancer = new Freelancer(firstName, lastName, pass);
		freelancer = service.save(freelancer);
		TypedQuery<Freelancer> query = entityManager.createQuery("from Freelancer", Freelancer.class);
		List<Freelancer> list = query.getResultList();
		Assertions.assertEquals(1, list.size());
		Freelancer stored = list.get(0);
		Assertions.assertEquals(firstName, stored.getFirstName());
		Assertions.assertEquals(lastName, stored.getLastName());
		Assertions.assertEquals(pass, stored.getPassword());
	}
	/* Testcase to find the data by id */
	@Test
	public void testFindById_1() {
		String firstName = "Dolly";
		String lastName = "Sharma";
		String pass = "root";
		Freelancer freelancer = new Freelancer(firstName, lastName, pass);
		entityManager.persist(freelancer);
		Long id = freelancer.getId();
		Freelancer actual = service.findById(id);
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
		Assertions.assertThrows(FreelancerNotFoundException.class, executable);

	}

	/**
	 * scenario: freelancer argument is null
	 */
	@Test
	public void testSave_2() {

		Freelancer freelancer = null;
		Executable executable = () -> service.save(freelancer);
		Assertions.assertThrows(InvalidArgumentException.class, executable);

	}

	/**
	 * scenario: when firstName is empty
	 */
	@Test
	public void testSave_3() {
		String firstName = "", lastName = "Samera", pass = "1234";
		Freelancer freelancer = new Freelancer(firstName, lastName, pass);
		Executable executable = () -> service.save(freelancer);
		Assertions.assertThrows(InvalidFreelancerNameException.class, executable);
	}

	/**
	 * scenario: when lastName is empty
	 */
	@Test
	public void testSave_4() {
		String firstName = "Dolly", lastName = "", pass = "1234";
		Freelancer freelancer = new Freelancer(firstName, lastName, pass);
		Executable executable = () -> service.save(freelancer);
		Assertions.assertThrows(InvalidFreelancerNameException.class, executable);
	}
}
