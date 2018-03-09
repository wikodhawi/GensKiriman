package share;

import java.math.BigDecimal;
import java.util.Date;

public class GensKirimanDto {
	private String companyCode;
	private String id;
	private String alamatAsal;
	private String alamatTujuan;
	private BigDecimal berat;
	private String createdBy;
	private Date createdDate;
	private BigDecimal hargaJenis;
	private BigDecimal hargaTotal;
	private String jenisKiriman;
	private String kodeWilayahAsal;
	private String kodeWilayahTujuan;
	private String namaPenerima;
	private String namaPengirim;
	private String updatedBy;
	private Date updatedDate;
	
	private String namaWilayahKotaAsal;
	private String namaWilayahKotaTujuan;
	
	private String resi;
	
	
	
	
	public String getResi() {
		return jenisKiriman+id;
	}

	public void setResi(String resi) {
		this.resi = resi;
	}

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlamatAsal() {
		return alamatAsal;
	}

	public void setAlamatAsal(String alamatAsal) {
		this.alamatAsal = alamatAsal;
	}

	public String getAlamatTujuan() {
		return alamatTujuan;
	}

	public void setAlamatTujuan(String alamatTujuan) {
		this.alamatTujuan = alamatTujuan;
	}

	public BigDecimal getBerat() {
		return berat;
	}

	public void setBerat(BigDecimal berat) {
		this.berat = berat;
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

	public BigDecimal getHargaJenis() {
		return hargaJenis;
	}

	public void setHargaJenis(BigDecimal hargaJenis) {
		this.hargaJenis = hargaJenis;
	}

	public BigDecimal getHargaTotal() {
		return hargaTotal;
	}

	public void setHargaTotal(BigDecimal hargaTotal) {
		this.hargaTotal = hargaTotal;
	}

	public String getJenisKiriman() {
		return jenisKiriman;
	}

	public void setJenisKiriman(String jenisKiriman) {
		this.jenisKiriman = jenisKiriman;
	}

	public String getKodeWilayahAsal() {
		return kodeWilayahAsal;
	}

	public void setKodeWilayahAsal(String kodeWilayahAsal) {
		this.kodeWilayahAsal = kodeWilayahAsal;
	}

	public String getKodeWilayahTujuan() {
		return kodeWilayahTujuan;
	}

	public void setKodeWilayahTujuan(String kodeWilayahTujuan) {
		this.kodeWilayahTujuan = kodeWilayahTujuan;
	}

	public String getNamaPenerima() {
		return namaPenerima;
	}

	public void setNamaPenerima(String namaPenerima) {
		this.namaPenerima = namaPenerima;
	}

	public String getNamaPengirim() {
		return namaPengirim;
	}

	public void setNamaPengirim(String namaPengirim) {
		this.namaPengirim = namaPengirim;
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
