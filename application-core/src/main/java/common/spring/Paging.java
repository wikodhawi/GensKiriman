package common.spring;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import common.util.CommonConstants;


public class Paging {
	/**
	 * Get Paging data
	 * @param page page #
	 * @param size total data per page
	 * @param direction asc / desc
	 * @param orderBy DB column order by
	 * @return
	 */
	public Pageable getPageable(int page, int size, String direction,
			String orderBy) {
		if (CommonConstants.DESC.equalsIgnoreCase(direction)) {
			if(orderBy.indexOf(",") > 0){
				String[] orderBys = orderBy.split(",");
				return new PageRequest(page, size, Direction.DESC, orderBys);
			} else {
				return new PageRequest(page, size, Direction.DESC, orderBy);
			}
		} else {
			if(orderBy.indexOf(",") > 0){
				String[] orderBys = orderBy.split(",");
				return new PageRequest(page, size, Direction.ASC, orderBys);
			} else {
				return new PageRequest(page, size, Direction.ASC, orderBy);
			}
		}
	}
}

