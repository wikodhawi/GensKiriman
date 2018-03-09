package common.formatter;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.Component;

public class DateTimeConverterUtil implements Converter {

	private SimpleDateFormat sdf = new SimpleDateFormat(Labels.getLabel("dateTimeFormat"));

	@Override
	public Object coerceToUi(Object beanProp, Component component,
			BindContext ctx) {
		final Date date = (Date) beanProp;
		return date == null ? null : sdf.format(date);
	}

	@Override
	public Object coerceToBean(Object compAttr, Component component,
			BindContext ctx) {
		final String date = (String) compAttr;
		sdf.setLenient(false);
		try {
			return date == null ? null : sdf.parse(date);
		} catch (ParseException e) {
			component.invalidate();
			return null;

		}
	}

}
