package common.component;


import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Textbox;

public class MyTextbox extends Textbox{
	private boolean autoUpper = true;	
	private static final long serialVersionUID = -3822064865606231482L;
 
	public MyTextbox(){
		if (autoUpper)
			setStyle("text-transform:uppercase");
	}
	
	@Override
	public void setValue(String value) throws WrongValueException {
		if (autoUpper){
			super.setValue(value.toUpperCase());
		}else{
			super.setValue(value);
		}
	}
	
	@Override
	public String getValue() throws WrongValueException {
		if (autoUpper){
			return super.getValue().toUpperCase();
		}else{
			return super.getValue();
		}
	}
	
	public boolean isAutoUpper() {
		return autoUpper;
	}

	public void setAutoUpper(boolean autoUpper) {		
		if (! autoUpper)
			setStyle("text-transform: none");
		
		this.autoUpper = autoUpper;
	}	
}