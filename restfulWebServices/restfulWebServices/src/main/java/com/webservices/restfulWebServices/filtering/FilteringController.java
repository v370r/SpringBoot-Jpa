package com.webservices.restfulWebServices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	@GetMapping("/filtering")
	public SomeBean retreiveSomeBean() {
		return new SomeBean("value1","value2","value3");
	}
	
	@GetMapping("/dynaFiltering")
	public MappingJacksonValue retreiveBeanDynamic() {
		SomeBean somebean = new SomeBean("value1","value2","value3");
		
		SimpleBeanPropertyFilter filter =SimpleBeanPropertyFilter
				.filterOutAllExcept("field1","field2");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(somebean);
		mapping.setFilters(filters);
		return mapping;
		
		
		
	}
	
	@GetMapping("/filterings")
	public List<SomeBean> retreiveSomeBeans(){
		return Arrays.asList(new SomeBean("value1","value2","value3"),new SomeBean("value1","value2","value3"),
				new SomeBean("value1","value2","value3"));
		
	}

}
