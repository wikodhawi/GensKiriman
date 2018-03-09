package core.dao.master;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.GensAdmin;
import core.model.GensAdminPK;

public interface GensAdminDao extends JpaRepository<GensAdmin, GensAdminPK>{

//	@Query("select a, b, c ,d from MstUserHdr a, MstCompany b, MstEmployee c, GensAdmin d "
//			+ "where a.employeeCode = :employeeCode and a.password = :password "
//			+ "and a.companyCode = b.companyCode "
//			+ "and a.companyCode = c.companyCode "
//			+ "and a.employeeCode = c.employeeCode "
//			+ "and a.employeeCode = d.employeeCode ")
//	public List<Object[]> getLogin(
//			@Param("companyCode") String companyCode,
//			@Param("password") String password);
	
	
	@Query("select g from GensAdmin g where g.username like :username and g.password like :password ")
	public List<GensAdmin> login(
			@Param("username") String username,
			@Param("password") String password);
}
