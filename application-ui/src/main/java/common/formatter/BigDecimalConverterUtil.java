package common.formatter;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Messagebox;

/**
 * 
 * @author Leo Sendra Using Example: <textbox value=
 *         "@bind(vm.number) @converter('bigDecimalConverter', format='#,###.##')"
 *         />
 */
public class BigDecimalConverterUtil implements Converter {

	@Override
	public Object coerceToUi(Object beanProp, Component component,
			BindContext ctx) {
		return beanProp;
	}

	@Override
	public Object coerceToBean(Object compAttr, Component component,
			BindContext ctx) {

		if (ctx.getConverterArg("format") == null) {
			Messagebox.show("Null format parameters!");
			return null;
		}

		if ((compAttr == null)) {
			// Messagebox.show("Not a BigDecimal");
			return null;
		}

		String format = (String) ctx.getConverterArg("format");
		DecimalFormat df = new DecimalFormat(format);
		df.setParseBigDecimal(true);

		BigDecimal bs = new BigDecimal(String.valueOf(compAttr));

		String result = df.format(bs);

		BigDecimal bd = null;
		try {
			bd = (BigDecimal) df.parse(result);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return bd;
	}

}
