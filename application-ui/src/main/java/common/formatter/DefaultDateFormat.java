package common.formatter;


import java.util.Locale;

import org.zkoss.text.DateFormatInfo;
import org.zkoss.util.resource.Labels;

public class DefaultDateFormat implements DateFormatInfo {
	String dateFormat = Labels.getLabel("dateFormat");
	String timeFormat = Labels.getLabel("timeFormat");
	String dateTimeFormat = Labels.getLabel("dateTimeFormat");
	
	@Override
	public String getDateFormat(int arg0, Locale arg1) {
		return dateFormat;
	}

	@Override
	public String getDateTimeFormat(int arg0, int arg1, Locale arg2) {
		return dateTimeFormat;
	}

	@Override
	public String getTimeFormat(int arg0, Locale arg1) {
		return timeFormat;
	}
}