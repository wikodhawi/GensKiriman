package core.dao.master;

import org.springframework.data.jpa.repository.JpaRepository;

import core.model.MstCounter;
import core.model.MstCounterPK;

public interface MstCounterDao extends JpaRepository<MstCounter, MstCounterPK> {

}
