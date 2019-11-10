package net.guides.springboot2.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.crud.model.BJAZ_IRCTC_TRV_PNR_DTLS;

@Repository
public interface BJAZ_IRCTC_TRV_PNR_DTLSRepository extends JpaRepository<BJAZ_IRCTC_TRV_PNR_DTLS, Long>{

}
