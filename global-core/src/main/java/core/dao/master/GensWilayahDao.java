package core.dao.master;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.GensWilayah;
import core.model.GensWilayahPK;
import core.model.MstColor;

public interface GensWilayahDao extends JpaRepository<GensWilayah, GensWilayahPK> {
	
	@Query("select a from GensWilayah a where a.namaWilayah like :search")
	public Page<GensWilayah> getDataLoadList(@Param("search") String search,
			Pageable page);
}
