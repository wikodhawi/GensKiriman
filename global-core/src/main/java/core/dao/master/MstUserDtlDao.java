package core.dao.master;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.MstUserDtl;
import core.model.MstUserDtlPK;

public interface MstUserDtlDao extends JpaRepository<MstUserDtl, MstUserDtlPK>{
	@Query("select a.roleCode from MstUserDtl a where a.employeeCode = :employeeCode")
	public List<String> getRoleCode(@Param("employeeCode") String employeeCode);
}
