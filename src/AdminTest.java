import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdminTest {
	Admin admin;
	@BeforeEach
	void setUp() throws Exception {
		admin=new Admin();
	}

	@Test
	void testGetter() { 
		assertEquals("admin",admin.getID());
		assertEquals("nayana",admin.getPassword());
	}
}
