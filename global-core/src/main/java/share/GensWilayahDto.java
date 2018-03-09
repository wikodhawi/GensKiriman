package share;

import java.io.Serializable;
import java.util.Date;

public class GensWilayahDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String companyCode;
	private String kodeWilayah;
	private String createdBy;
	private Date createdDate;
	private double latitude;
	private double longitude;
	private String namaWilayah;
	private String updatedBy;
	private Date updatedDate;
	
	private String namaWilayahKotaAsal;
	private String namaWilayahKotaTujuan;
	
	
	
	public String getNamaWilayahKotaAsal() {
		return namaWilayahKotaAsal;
	}
	public void setNamaWilayahKotaAsal(String namaWilayahKotaAsal) {
		this.namaWilayahKotaAsal = namaWilayahKotaAsal;
	}
	public String getNamaWilayahKotaTujuan() {
		return namaWilayahKotaTujuan;
	}
	public void setNamaWilayahKotaTujuan(String namaWilayahKotaTujuan) {
		this.namaWilayahKotaTujuan = namaWilayahKotaTujuan;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getKodeWilayah() {
		return kodeWilayah;
	}
	public void setKodeWilayah(String kodeWilayah) {
		this.kodeWilayah = kodeWilayah;
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
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getNamaWilayah() {
		return namaWilayah;
	}
	public void setNamaWilayah(String namaWilayah) {
		this.namaWilayah = namaWilayah;
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
