package com.vsr.services.remainderapp.jaxrs;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.vsr.services.remainderapp.domain.FilteringBean;
import com.vsr.services.remainderapp.domain.FilteringDynamicBean;

@Component
public class FilteringResourceImpl implements FilteringResource {
	
	public FilteringBean retrieveBean() {
		return new FilteringBean("value1", "value2", "value3");
	}

	@Override
	public MappingJacksonValue retrieveBean1() {
		FilteringDynamicBean filteringDynamicBean = new FilteringDynamicBean("value1", "value2","value3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("feild1,feild2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("dynamicBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(filteringDynamicBean);
		mapping.setFilters(filters);
		
		return mapping;
	}

	@Override
	public MappingJacksonValue retrieveBean2() {
		FilteringDynamicBean filteringDynamicBean = new FilteringDynamicBean("value1", "value2","value3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("feild1,feild3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("dynamicBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(filteringDynamicBean);
		mapping.setFilters(filters);
		
		return mapping;
	}

}
