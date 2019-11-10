package net.guides.springboot2.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.crud.exception.ResourceNotFoundException;
import net.guides.springboot2.crud.model.BJAZ_IRCTC_TRV_PNR_DTLS;
import net.guides.springboot2.crud.repository.BJAZ_IRCTC_TRV_PNR_DTLSRepository;

@RestController
@RequestMapping("/api/v1")
public class PnrController {
	@Autowired
	private BJAZ_IRCTC_TRV_PNR_DTLSRepository BJAZ_IRCTC_TRV_PNR_DTLSRepository;

	@GetMapping("/BJAZ_IRCTC_TRV_PNR_DTLSs")
	public List<BJAZ_IRCTC_TRV_PNR_DTLS> getAllBJAZ_IRCTC_TRV_PNR_DTLSs() {
		return BJAZ_IRCTC_TRV_PNR_DTLSRepository.findAll();
	}

	@GetMapping("/BJAZ_IRCTC_TRV_PNR_DTLSs/{id}")
	public ResponseEntity<BJAZ_IRCTC_TRV_PNR_DTLS> getBJAZ_IRCTC_TRV_PNR_DTLSById(@PathVariable(value = "id") Long BJAZ_IRCTC_TRV_PNR_DTLSId)
			throws ResourceNotFoundException {
		BJAZ_IRCTC_TRV_PNR_DTLS BJAZ_IRCTC_TRV_PNR_DTLS = BJAZ_IRCTC_TRV_PNR_DTLSRepository.findById(BJAZ_IRCTC_TRV_PNR_DTLSId)
				.orElseThrow(() -> new ResourceNotFoundException("BJAZ_IRCTC_TRV_PNR_DTLS not found for this id :: " + BJAZ_IRCTC_TRV_PNR_DTLSId));
		return ResponseEntity.ok().body(BJAZ_IRCTC_TRV_PNR_DTLS);
	}

	@PostMapping("/BJAZ_IRCTC_TRV_PNR_DTLSs")
	public BJAZ_IRCTC_TRV_PNR_DTLS createBJAZ_IRCTC_TRV_PNR_DTLS(@Valid @RequestBody BJAZ_IRCTC_TRV_PNR_DTLS BJAZ_IRCTC_TRV_PNR_DTLS) {
		return BJAZ_IRCTC_TRV_PNR_DTLSRepository.save(BJAZ_IRCTC_TRV_PNR_DTLS);
	}

	@PutMapping("/BJAZ_IRCTC_TRV_PNR_DTLSs/{id}")
	public ResponseEntity<BJAZ_IRCTC_TRV_PNR_DTLS> updateBJAZ_IRCTC_TRV_PNR_DTLS(@PathVariable(value = "id") Long BJAZ_IRCTC_TRV_PNR_DTLSId,
			@Valid @RequestBody BJAZ_IRCTC_TRV_PNR_DTLS BJAZ_IRCTC_TRV_PNR_DTLSDetails) throws ResourceNotFoundException {
		BJAZ_IRCTC_TRV_PNR_DTLS BJAZ_IRCTC_TRV_PNR_DTLS = BJAZ_IRCTC_TRV_PNR_DTLSRepository.findById(BJAZ_IRCTC_TRV_PNR_DTLSId)
				.orElseThrow(() -> new ResourceNotFoundException("BJAZ_IRCTC_TRV_PNR_DTLS not found for this id :: " + BJAZ_IRCTC_TRV_PNR_DTLSId));

		BJAZ_IRCTC_TRV_PNR_DTLS.setE_MAIL(BJAZ_IRCTC_TRV_PNR_DTLSDetails.getE_MAIL());
		BJAZ_IRCTC_TRV_PNR_DTLS.setMOBILE_NO(BJAZ_IRCTC_TRV_PNR_DTLSDetails.getMOBILE_NO());
		//BJAZ_IRCTC_TRV_PNR_DTLS.setFirstName(BJAZ_IRCTC_TRV_PNR_DTLSDetails.getFirstName());
		final BJAZ_IRCTC_TRV_PNR_DTLS updatedBJAZ_IRCTC_TRV_PNR_DTLS = BJAZ_IRCTC_TRV_PNR_DTLSRepository.save(BJAZ_IRCTC_TRV_PNR_DTLS);
		return ResponseEntity.ok(updatedBJAZ_IRCTC_TRV_PNR_DTLS);
	}

	@DeleteMapping("/BJAZ_IRCTC_TRV_PNR_DTLSs/{id}")
	public Map<String, Boolean> deleteBJAZ_IRCTC_TRV_PNR_DTLS(@PathVariable(value = "id") Long BJAZ_IRCTC_TRV_PNR_DTLSId)
			throws ResourceNotFoundException {
		BJAZ_IRCTC_TRV_PNR_DTLS BJAZ_IRCTC_TRV_PNR_DTLS = BJAZ_IRCTC_TRV_PNR_DTLSRepository.findById(BJAZ_IRCTC_TRV_PNR_DTLSId)
				.orElseThrow(() -> new ResourceNotFoundException("BJAZ_IRCTC_TRV_PNR_DTLS not found for this id :: " + BJAZ_IRCTC_TRV_PNR_DTLSId));

		BJAZ_IRCTC_TRV_PNR_DTLSRepository.delete(BJAZ_IRCTC_TRV_PNR_DTLS);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
