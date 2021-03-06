package common.validator;


import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.util.Clients;

/**
 * Validator class for validating not empty field.
 * @author Leo Sendra
 *
 */
public class NotEmptyValidator extends AbstractValidator {

	@Override
	public void validate(ValidationContext ctx) {
		String obj = (String)ctx.getProperty().getValue();
		
		if (obj.trim().isEmpty()){
			Clients.wrongValue(ctx.getBindContext().getComponent(), Labels.getLabel("MZul.2000"));
            ctx.setInvalid(); 
		}
	}

}
