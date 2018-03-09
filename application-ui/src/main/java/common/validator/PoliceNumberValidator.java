package common.validator;


import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.util.Clients;

/**
 * Validator class for validating Police Number format field.
 * @author Leo Sendra
 *
 */
public class PoliceNumberValidator extends AbstractValidator {

	@Override
	public void validate(ValidationContext ctx) {
		String policeNumber = (String)ctx.getProperty().getValue();
		
		if(policeNumber != null && !policeNumber.matches("[A-Z]{1,2}[1-9]{1}\\d{0,3}[A-Z]{0,3}") && !policeNumber.isEmpty()) {
			Clients.wrongValue(ctx.getBindContext().getComponent(), Labels.getLabel("E045"));
            ctx.setInvalid();           
            
        }
	}

}
