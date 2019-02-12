package com.raje.myprofile;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.raje.myprofile.view.ProfileController;
/**
 * Tests if the controller is loaded
 * @author fsylvia
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {
	
	@Autowired
	ProfileController controller;
	
	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
