package core.dao.master;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import core.model.GensHargaKiriman5;
import core.model.GensHargaKirimanPK5;

public interface GensHargaKirimanDao5 extends JpaRepository<GensHargaKiriman5, GensHargaKirimanPK5>{

	@Query("select g from GensHargaKiriman5 g")
	public Page<GensHargaKiriman5> getDataLoadList(Pageable page);
}
 
