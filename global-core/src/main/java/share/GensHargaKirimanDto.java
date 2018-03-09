package share;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GensHargaKirimanDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String companyCode;
	private String kodeKiriman;
	private String createdBy;
	private Date createdDate;
	private BigDecimal hargaPerSkor;
	private String jenisKiriman;
	private String updatedBy;
	private Date updatedDate;
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getKodeKiriman() {
		return kodeKiriman;
	}
	public void setKodeKiriman(String kodeKiriman) {
		this.kodeKiriman = kodeKiriman;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public BigDecimal getHargaPerSkor() {
		return hargaPerSkor;
	}
	public void setHargaPerSkor(BigDecimal hargaPerSkor) {
		this.hargaPerSkor = hargaPerSkor;
	}
	public String getJenisKiriman() {
		return jenisKiriman;
	}
	public void setJenisKiriman(String jenisKiriman) {
		this.jenisKiriman = jenisKiriman;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	
	
}
