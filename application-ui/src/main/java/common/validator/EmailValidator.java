package common.validator;


import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.util.Clients;

/**
 * Validator class for validating email format field.
 * @author Leo Sendra
 *
 */
public class EmailValidator extends AbstractValidator {

	@Override
	public void validate(ValidationContext ctx) {
		String email = (String)ctx.getProperty().getValue();
		
		if(email != null && !email.matches(".+@.+\\.[a-zA-Z]+") && !email.isEmpty()) {
			Clients.wrongValue(ctx.getBindContext().getComponent(), Labels.getLabel("E005"));
            ctx.setInvalid();           
        }
	}

}
