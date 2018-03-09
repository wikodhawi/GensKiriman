package common.validator;


import java.math.BigDecimal;

import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.util.Clients;

public class NumericRangeValidator extends AbstractValidator {

	@Override
	public void validate(ValidationContext ctx) {
		String compareProp = (String) ctx.getBindContext().getValidatorArg(
				"compare");
		Boolean isGreater = (Boolean) ctx.getBindContext().getValidatorArg(
				"greater");
		Boolean isEqual = (Boolean) ctx.getBindContext().getValidatorArg(
				"equal");

		if (ctx.getProperties(compareProp) == null) return;
		
		BigDecimal compareDecimalVal = toBigdecimal(ctx.getProperties(compareProp)[0]
				.getValue());
		BigDecimal decimalVal = toBigdecimal(ctx.getProperty().getValue());
		
		if (decimalVal == null || compareDecimalVal == null) return;
		
		boolean isValid = false;

		if (isGreater && !isEqual) { 
			if (decimalVal.compareTo(compareDecimalVal) > 0)
				isValid = true;
		} else if (isGreater && isEqual) { 
			if (decimalVal.compareTo(compareDecimalVal) >= 0)
				isValid = true;
		} else if (!isGreater && !isEqual) { 
			if (decimalVal.compareTo(compareDecimalVal) < 0)
				isValid = true;
		} else { 
			if (decimalVal.compareTo(compareDecimalVal) <= 0)
				isValid = true;
		}

		if (!isValid) {
			Clients.wrongValue(ctx.getBindContext().getComponent(),
					Labels.getLabel("E118"));
			ctx.setInvalid();
		} else {
			Clients.clearWrongValue(ctx.getBindContext().getComponent());
		}
	}
	
	public BigDecimal toBigdecimal(Object obj){
		BigDecimal bd = new BigDecimal(0);
		if(obj instanceof Long){
			bd = new BigDecimal((Long)obj);
		}else if(obj instanceof Integer){
			bd = new BigDecimal((Integer)obj);
		}else{
			bd = (BigDecimal) obj;
		}
		
		return bd;
	}
}