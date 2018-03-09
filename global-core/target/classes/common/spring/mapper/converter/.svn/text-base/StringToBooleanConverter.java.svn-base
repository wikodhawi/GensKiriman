package common.spring.mapper.converter;

import org.springframework.stereotype.Component;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

@Component
public class StringToBooleanConverter extends BidirectionalConverter<String, Boolean> {

	@Override
	public Boolean convertTo(String source, Type<Boolean> destinationType) {
		if(source.equalsIgnoreCase("1")){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public String convertFrom(Boolean source, Type<String> destinationType) {
		return source ? "1" :"0";
	}

}
