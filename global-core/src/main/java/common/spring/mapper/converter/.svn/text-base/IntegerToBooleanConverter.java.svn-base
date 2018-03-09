package common.spring.mapper.converter;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import org.springframework.stereotype.Component;

@Component
public class IntegerToBooleanConverter extends
		BidirectionalConverter<Integer, Boolean> {

	@Override
	public Boolean convertTo(Integer source, Type<Boolean> destinationType) {
		if (source == 0)
			return false;
		else
			return true;
	}

	@Override
	public Integer convertFrom(Boolean source, Type<Integer> destinationType) {
		return source ? 1 : 0;
	}
	
	

}
