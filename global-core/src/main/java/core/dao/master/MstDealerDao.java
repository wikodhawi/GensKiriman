package core.dao.master;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import core.model.MstDealer;
import core.model.MstDealerPK;
import core.model.MstGroupDealer;

public interface MstDealerDao extends JpaRepository<MstDealer, MstDealerPK> {

	@Query("select a from MstDealer a")
	public Page<MstDealer> getDataLoadList(Pageable page);
}
