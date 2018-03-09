package core.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public abstract class BaseDaoImpl {

	@PersistenceContext
	private EntityManager em;

	protected Map<String, Object> getPaging(String sql, Pageable pageable,
			Object... params) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalRecords", getSizePaging(sql, params));
		map.put("contentData", getListDataPaging(sql, pageable, params));
		return map;
	}

	protected long getSizePaging(String sql, Object... params) {
		String q = "SELECT COUNT(*) AS COUNT FROM (" + sql + " ) AB";
		if (params != null) {
			Query query = em.createNativeQuery(q);
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
			}
			return toLong(query.getSingleResult());
		} else {
			return toLong(em.createNativeQuery(q).getSingleResult());
		}

	}

	protected long toLong(Object obj) {
		long result = 0;
		if (obj instanceof Integer) {
			result = (Long) obj;
		} else if (obj instanceof BigDecimal) {
			result = ((BigDecimal) obj).longValue();
		} else if (obj instanceof Double) {
			result = ((Double) obj).longValue();
		} else {
			result = Long.parseLong(obj.toString());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	protected List<Object[]> getListDataPaging(String sql, Pageable pageable, Object... params) {
		String orderBy = "";
		String direction = "ASC";
		for (Iterator<Sort.Order> itr = pageable.getSort().iterator(); itr
				.hasNext();) {
			Sort.Order order = itr.next();
			if (orderBy == null || orderBy.isEmpty()) {
				orderBy = order.getProperty();
			} else {
				orderBy = orderBy + ", " + order.getProperty();
			}
			direction = order.getDirection().name();
			// break;
		}
		String q = "SELECT * FROM (SELECT AA.*, ROWNUM AS NOURUT FROM(" + sql
				+ " ORDER BY " + orderBy + " " + direction + ")AA ) WHERE "
				+ ((pageable.getPageNumber() + 1) * pageable.getPageSize())
				+ " >=  NOURUT AND NOURUT > "
				+ (pageable.getPageNumber() * pageable.getPageSize());
		
		if (params != null) {
			Query query = em.createNativeQuery(q);
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
			}
			return query.getResultList();
		} else {
			return em.createNativeQuery(q).getResultList();
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	protected List<Object[]> getListData(String sql, Object... params) {		
		if (params != null) {
			Query query = em.createNativeQuery(sql);
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
			}
			return query.getResultList();
		} else {
			return em.createNativeQuery(sql).getResultList();
		}		
	}
	
	public void update(String sql, Object... params){
		if (params != null) {
			Query query = em.createNativeQuery(sql);
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
			}
			query.executeUpdate();
		} else {
			em.createNativeQuery(sql).executeUpdate();
		}
	}

	protected long getSizePagingNew(String sql, Map<String,Object> params) {
		String q = "SELECT COUNT(*) AS COUNT FROM (" + sql + " ) AB";
		if (params != null) {
			Query query = em.createNativeQuery(q);
			for (Map.Entry<String, Object> maps : params.entrySet()) {
				query.setParameter(maps.getKey(), maps.getValue());
			}
			return toLong(query.getSingleResult());
		} else {
			return toLong(em.createNativeQuery(q).getSingleResult());
		}

	}
	
	@SuppressWarnings("unchecked")
	protected List<Object[]> getListDataPagingNew(String sql, Pageable pageable, Map<String,Object> params) {
		String orderBy = "";
		String direction = "ASC";
		for (Iterator<Sort.Order> itr = pageable.getSort().iterator(); itr
				.hasNext();) {
			Sort.Order order = itr.next();
			if (orderBy == null || orderBy.isEmpty()) {
				orderBy = order.getProperty();
			} else {
				orderBy = orderBy + ", " + order.getProperty();
			}
			direction = order.getDirection().name();			
		}
		
		String q = "SELECT * FROM (SELECT AA.*, ROWNUM AS NOURUT FROM(" + sql
				+ " ORDER BY " + orderBy + " " + direction + ")AA ) WHERE "
				+ ((pageable.getPageNumber() + 1) * pageable.getPageSize())
				+ " >=  NOURUT AND NOURUT > "
				+ (pageable.getPageNumber() * pageable.getPageSize());
		
		if (params != null) {
			Query query = em.createNativeQuery(q);
			for (Map.Entry<String, Object> maps : params.entrySet()) {
				if(maps.getValue() instanceof List<?>) {
					query.setParameter(maps.getKey(), (List<String>) maps.getValue());
				} else {
					query.setParameter(maps.getKey(), maps.getValue());
				}
			}
			return query.getResultList();
		} else {
			return em.createNativeQuery(q).getResultList();
		}		
	}
	
	protected List<Object[]> getListDataNew(String sql, Map<String,Object> params) {
		if (params != null) {
			Query query = em.createNativeQuery(sql);
			for (Map.Entry<String, Object> maps : params.entrySet()) {
				if(maps.getValue() instanceof List<?>) {
					query.setParameter(maps.getKey(), (List<String>) maps.getValue());
				} else {
					query.setParameter(maps.getKey(), maps.getValue());
				}
			}
			return query.getResultList();
		} else {
			return em.createNativeQuery(sql).getResultList();
		}		
	}
	
	protected java.util.Date callProcedurePrcWorkDay(java.util.Date p_vtanggal, String p_vbranch, Integer p_vflag){
		StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("prc_workday");
		// set parameters
		storedProcedure.registerStoredProcedureParameter("p_vtanggal", java.util.Date.class, ParameterMode.INOUT);
		storedProcedure.registerStoredProcedureParameter("p_vbranch", String.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("p_vflag", Integer.class, ParameterMode.IN);
		storedProcedure.setParameter("p_vtanggal", p_vtanggal);
		storedProcedure.setParameter("p_vbranch", p_vbranch);
		storedProcedure.setParameter("p_vflag", p_vflag);
		
		// execute SP
		storedProcedure.execute();
		// get result
		java.util.Date dateRes = (java.util.Date)storedProcedure.getOutputParameterValue("p_vtanggal");
		return dateRes;
	}
	
	protected java.util.Date callProcedurePrcAddWorkDay(String p_vcompany_code, java.util.Date p_vdate1, Integer days){
		StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("PRC_ADD_WORKDAY");
		// set parameters
		storedProcedure.registerStoredProcedureParameter("p_vdate1", java.util.Date.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("p_vcompany_code", String.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("days", Integer.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("p_vdate2", java.util.Date.class, ParameterMode.OUT);
		storedProcedure.setParameter("p_vdate1", p_vdate1);
		storedProcedure.setParameter("p_vcompany_code", p_vcompany_code);
		storedProcedure.setParameter("days", days);
		
		// execute SP
		storedProcedure.execute();
		// get result
		java.util.Date dateRes = (java.util.Date) storedProcedure.getParameter("p_vdate2");
		return dateRes;
	}
}