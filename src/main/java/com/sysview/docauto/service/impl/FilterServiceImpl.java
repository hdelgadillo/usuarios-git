/*package com.sysview.docauto.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysview.docauto.dao.FilterDAO;
import com.sysview.docauto.model.Filter;
import com.sysview.docauto.service.FilterService;

@Service("filterService")
public class FilterServiceImpl implements FilterService {
	@Autowired
	  
	private static final Logger log = LoggerFactory.getLogger(FilterServiceImpl.class);
	
	
	@Autowired FilterDAO filterDao;
	    
	@Override
	public List<Filter> filterBy(Filter filter) {
		return filterDao.filterBy(filter);
	}
	


}
*/