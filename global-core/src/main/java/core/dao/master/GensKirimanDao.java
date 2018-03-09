package core.dao.master;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.GensKiriman;
import core.model.GensKirimanPK;
import core.model.GensWilayah;

public interface GensKirimanDao extends JpaRepository<GensKiriman, GensKirimanPK>{
	
	
	@Query("select g from GensKiriman g where g.namaPengirim like :search")
	public Page<GensKiriman> getDataLoadList(@Param("search") String search, Pageable page);
	
	
	@Query("select g from GensKiriman g where g.id like :searchId and g.jenisKiriman like :searchJenisKiriman ")
	public List<GensKiriman> searchResi(@Param("searchId") String searchId,@Param("searchJenisKiriman") String searchJenisKiriman);
	
}