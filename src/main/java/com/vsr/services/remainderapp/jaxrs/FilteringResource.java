package com.vsr.services.remainderapp.jaxrs;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vsr.services.remainderapp.domain.FilteringBean;

@RestController
public interface FilteringResource {
	
	//static filtering
	@GetMapping(path="/filtering")
	public FilteringBean retrieveBean();
	
	//dynamic filtering (feild 1, feild 2)
	@GetMapping(path="/filteringD1")
	public MappingJacksonValue retrieveBean1();
	
	
	//dynamic filtering (feild2, feild3)
	@GetMapping(path="/filteringD2")
	public MappingJacksonValue retrieveBean2();
	
}
