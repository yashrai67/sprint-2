package org.cap.apps.freelancerapp.bookmarkedfreelancer.service;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(BookmarkedFreelancerServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class BookmarkedFreelancerServiceImplTest {
	@Autowired
	IBookmarkedFreelancerService service;
	
	@Autowired
	private EntityManager entityManager;
	
	
	

}
