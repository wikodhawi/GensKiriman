package common.validator;


import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.util.Clients;

/**
 * Validator class for validating alphabetic format field.
 * 
 * @author Giovanni Umboh
 * 
 */

public class AlphabetValidator extends AbstractValidator {

	@Override
	public void validate(ValidationContext ctx) {
		String alphabet = (String) ctx.getProperty().getValue();
		if (alphabet != null && !alphabet.matches("[A-Za-z|\\s]*")
				&& !alphabet.isEmpty()) {
			Clients.wrongValue(ctx.getBindContext().getComponent(),
					Labels.getLabel("E047"));
			ctx.setInvalid();
		}

	}

}
