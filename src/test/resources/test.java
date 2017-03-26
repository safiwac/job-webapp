import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.service.manager.impl.PaysManagerImpl;

import job.service.config.TestConfiguration;

/*
 * @author EL HAHY Zakaria
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
public class test {

	@Autowired
	PaysManagerImpl pyasManager;
	
	@Test
	public void testConnexion(){
		System.out.println("ffdff"+pyasManager.findAllCountry().size());
		
	}
}
