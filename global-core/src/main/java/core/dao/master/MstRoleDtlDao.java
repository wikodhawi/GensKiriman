package core.dao.master;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.MstRoleDtl;
import core.model.MstRoleDtlPK;

public interface MstRoleDtlDao extends JpaRepository<MstRoleDtl, MstRoleDtlPK>{
	
	@Query("select a.actionName from MstRoleDtl a where a.roleCode in :roleCode and a.menuCode = :menuCode ")
	public List<String> getDtlByRoleCodeAndMenuCode(
			@Param("roleCode") Set<String> roleCode, 
			@Param("menuCode") String menuCode);
}
