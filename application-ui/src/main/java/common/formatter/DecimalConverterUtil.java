package common.formatter;


import java.text.DecimalFormat;
import java.text.ParseException;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.zk.ui.Component;

public class DecimalConverterUtil implements Converter {

	private DecimalFormat df = new DecimalFormat("#,##0.00");

	@Override
	public Object coerceToUi(Object beanProp, Component component,
			BindContext ctx) {
		final Double d = (Double) beanProp;
		return d == null ? null : df.format(d);
	}

	@Override
	public Object coerceToBean(Object compAttr, Component component,
			BindContext ctx) {
		final String d = (String) compAttr;
	
		try {
			return d == null ? null : df.parse(d);
		} catch (ParseException e) {
			component.invalidate();
			return null;
		}
	}

}
