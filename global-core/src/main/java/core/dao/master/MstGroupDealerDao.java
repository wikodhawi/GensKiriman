package core.dao.master;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import core.model.MstGroupDealer;
import core.model.MstGroupDealerPK;

public interface MstGroupDealerDao extends JpaRepository<MstGroupDealer, MstGroupDealerPK> {
	
	@Query("select a from MstGroupDealer a")
	public Page<MstGroupDealer> getDataLoadList(Pageable page);
}
