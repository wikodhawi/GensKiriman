package core.dao.master;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.GensHargaKiriman;
import core.model.GensHargaKirimanPK;
import core.model.MstColor;

public interface GensHargaKirimanDao extends JpaRepository<GensHargaKiriman, GensHargaKirimanPK> {
	
}
