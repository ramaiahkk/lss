package com.takoit.utils.lss;

import com.takoit.utils.lss.controller.LSController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LssApplicationTests {
	@Autowired
	private LSController lsController;

	@Test
	void contextLoads() {
		Assertions.assertTrue(lsController!=null);
	}

}
