package core.dao.master;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.MstUserHdr;
import core.model.MstUserHdrPK;

public interface MstUserHdrDao extends JpaRepository<MstUserHdr, MstUserHdrPK>{

	@Query("select a, b, c from MstUserHdr a, MstCompany b, MstEmployee c "
			+ "where a.employeeCode = :employeeCode and a.password = :password "
			+ "and a.companyCode = b.companyCode "
			+ "and a.companyCode = c.companyCode "
			+ "and a.employeeCode = c.employeeCode ")
	public List<Object[]> getLogin(
			@Param("employeeCode") String employeeCode,
			@Param("password") String password);
}
