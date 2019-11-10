package net.guides.springboot2.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BJAZ_IRCTC_TRV_PNR_DTLS")
public class BJAZ_IRCTC_TRV_PNR_DTLS {

	
	private String MASTER_POLICY_REF;
	private String E_MAIL;
	private String MOBILE_NO;
	private Long PNR_NUMBER;
	
	public BJAZ_IRCTC_TRV_PNR_DTLS() {
		
	}
	
	public BJAZ_IRCTC_TRV_PNR_DTLS(String MASTER_POLICY_REF, String E_MAIL, String MOBILE_NO,Long PNR_NUMBER) {
		this.MASTER_POLICY_REF = MASTER_POLICY_REF;
		this.E_MAIL = E_MAIL;
		this.MOBILE_NO = MOBILE_NO;
		this.PNR_NUMBER=PNR_NUMBER;
	}

	/**
	 * @return the mASTER_POLICY_REF
	 */
	@Column(name = "MASTER_POLICY_REF", nullable = false)
	public String getMASTER_POLICY_REF() {
		return MASTER_POLICY_REF;
	}

	/**
	 * @param mASTER_POLICY_REF the mASTER_POLICY_REF to set
	 */
	public void setMASTER_POLICY_REF(String mASTER_POLICY_REF) {
		MASTER_POLICY_REF = mASTER_POLICY_REF;
	}

	/**
	 * @return the e_MAIL
	 */
	@Column(name = "E_MAIL", nullable = false)
	public String getE_MAIL() {
		return E_MAIL;
	}

	/**
	 * @param e_MAIL the e_MAIL to set
	 */
	public void setE_MAIL(String e_MAIL) {
		E_MAIL = e_MAIL;
	}

	/**
	 * @return the mOBILE_NO
	 */
	@Column(name = "MOBILE_NO", nullable = false)
	public String getMOBILE_NO() {
		return MOBILE_NO;
	}

	/**
	 * @param mOBILE_NO the mOBILE_NO to set
	 */
	public void setMOBILE_NO(String mOBILE_NO) {
		MOBILE_NO = mOBILE_NO;
	}

	/**
	 * @return the pNR_NUMBER
	 */
	@Id
	@Column(name="PNR_NUMBER",nullable=false)
	public Long getPNR_NUMBER() {
		return PNR_NUMBER;
	}

	/**
	 * @param pNR_NUMBER the pNR_NUMBER to set
	 */
	public void setPNR_NUMBER(Long pNR_NUMBER) {
		PNR_NUMBER = pNR_NUMBER;
	}
	
	
	
	
	
	
}
