package net.guides.springboot2.springboot2jpacrudexample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import net.guides.springboot2.crud.Application;
import net.guides.springboot2.crud.model.BJAZ_IRCTC_TRV_PNR_DTLS;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BJAZ_IRCTC_TRV_PNR_DTLSControllerIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllBJAZ_IRCTC_TRV_PNR_DTLSs() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/BJAZ_IRCTC_TRV_PNR_DTLSs",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetBJAZ_IRCTC_TRV_PNR_DTLSById() {
		BJAZ_IRCTC_TRV_PNR_DTLS BJAZ_IRCTC_TRV_PNR_DTLS = restTemplate.getForObject(getRootUrl() + "/BJAZ_IRCTC_TRV_PNR_DTLSs/1", BJAZ_IRCTC_TRV_PNR_DTLS.class);
		System.out.println(BJAZ_IRCTC_TRV_PNR_DTLS.getE_MAIL());
		assertNotNull(BJAZ_IRCTC_TRV_PNR_DTLS);
	}

	@Test
	public void testCreateBJAZ_IRCTC_TRV_PNR_DTLS() {
		BJAZ_IRCTC_TRV_PNR_DTLS BJAZ_IRCTC_TRV_PNR_DTLS = new BJAZ_IRCTC_TRV_PNR_DTLS();
		BJAZ_IRCTC_TRV_PNR_DTLS.setE_MAIL("admin@gmail.com");
		BJAZ_IRCTC_TRV_PNR_DTLS.setMASTER_POLICY_REF("admin");
		//BJAZ_IRCTC_TRV_PNR_DTLS.setLastName("admin");

		ResponseEntity<BJAZ_IRCTC_TRV_PNR_DTLS> postResponse = restTemplate.postForEntity(getRootUrl() + "/BJAZ_IRCTC_TRV_PNR_DTLSs", BJAZ_IRCTC_TRV_PNR_DTLS, BJAZ_IRCTC_TRV_PNR_DTLS.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateBJAZ_IRCTC_TRV_PNR_DTLS() {
		Long id = (long) 233;
		BJAZ_IRCTC_TRV_PNR_DTLS BJAZ_IRCTC_TRV_PNR_DTLS = restTemplate.getForObject(getRootUrl() + "/BJAZ_IRCTC_TRV_PNR_DTLSs/" + id, BJAZ_IRCTC_TRV_PNR_DTLS.class);
		BJAZ_IRCTC_TRV_PNR_DTLS.setE_MAIL("admin1");
		//BJAZ_IRCTC_TRV_PNR_DTLS.setLastName("admin2");

		restTemplate.put(getRootUrl() + "/BJAZ_IRCTC_TRV_PNR_DTLSs/" + id, BJAZ_IRCTC_TRV_PNR_DTLS);

		BJAZ_IRCTC_TRV_PNR_DTLS updatedBJAZ_IRCTC_TRV_PNR_DTLS = restTemplate.getForObject(getRootUrl() + "/BJAZ_IRCTC_TRV_PNR_DTLSs/" + id, BJAZ_IRCTC_TRV_PNR_DTLS.class);
		assertNotNull(updatedBJAZ_IRCTC_TRV_PNR_DTLS);
	}

	@Test
	public void testDeleteBJAZ_IRCTC_TRV_PNR_DTLS() {
		int id = 2;
		BJAZ_IRCTC_TRV_PNR_DTLS BJAZ_IRCTC_TRV_PNR_DTLS = restTemplate.getForObject(getRootUrl() + "/BJAZ_IRCTC_TRV_PNR_DTLSs/" + id, BJAZ_IRCTC_TRV_PNR_DTLS.class);
		assertNotNull(BJAZ_IRCTC_TRV_PNR_DTLS);

		restTemplate.delete(getRootUrl() + "/BJAZ_IRCTC_TRV_PNR_DTLSs/" + id);

		try {
			BJAZ_IRCTC_TRV_PNR_DTLS = restTemplate.getForObject(getRootUrl() + "/BJAZ_IRCTC_TRV_PNR_DTLSs/" + id, BJAZ_IRCTC_TRV_PNR_DTLS.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}
