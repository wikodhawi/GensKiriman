package core.mapper;

import javax.annotation.PostConstruct;

import ma.glasnost.orika.MapperFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import common.spring.mapper.OrikaConfigurableMapper;


@Component
public class MapperConfig {
	@Autowired
	private OrikaConfigurableMapper orikaConfigurableMapper;

	private MapperFactory mapperFactory;

	@PostConstruct
	public void init() {
		mapperFactory = orikaConfigurableMapper.getMapperFactory();
	}
}