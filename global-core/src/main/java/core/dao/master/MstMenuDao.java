package core.dao.master;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.MstMenu;

public interface MstMenuDao extends JpaRepository<MstMenu, String>{
	
	@Query("select a, b "
			+ "from MstMenu a, MstRoleHdr b, MstRoleDtl c, MstEmployee d "
			+ "where d.employeeCode = :employeeCode "
			+ "and d.companyCode = :companyCode "
			+ "and d.positionCode = b.positionCode "
			+ "and d.companyCode = b.companyCode "
			+ "and b.roleCode = c.roleCode "
			+ "and c.menuCode = a.menuCode")
	public List<Object[]> getMenuChild(@Param("employeeCode") String employeeCode,
			@Param("companyCode") String companyCode);
	
	@Query("select a "
			+ "from MstMenu a "
			+ "where a.menuCode in :menuCode ")
	public List<MstMenu> getMenuParent(@Param("menuCode") Set<String> menuCode);
}
