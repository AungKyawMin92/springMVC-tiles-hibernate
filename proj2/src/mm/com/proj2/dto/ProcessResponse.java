package mm.com.proj2.dto;

import java.util.List;

import org.springframework.validation.FieldError;

public class ProcessResponse extends Exception{
	private static final long serialVersionUID = 1519900408342597475L;

	private ReturnType returnType;
	private List<FieldError> fieldErrorList;

	public ProcessResponse(ReturnType returnType) {
		super(returnType.getDescription());
		this.setReturnType(returnType);
	}
	public ProcessResponse(ReturnType returnType, List<FieldError> fieldErrorList) {
		super(returnType.getDescription());
		this.setReturnType(returnType);
		this.setFieldErrorList(fieldErrorList);
	}

	public enum ReturnType {	
		
		
		SAVE_SUCCESS(1, "Save Success"),
		SAVE_FAIL(0, "Save Fail");
		
		
		
		
		private ReturnType(int code, String desc) {
			this.code = code;
			description = desc;
		}
		public int getCode() {
			return code;
		}
		public String getDescription() {
			return description;
		}
		private final int code;
		private final String description;
	}

	public ReturnType getReturnType() {
		return returnType;
	}
	public void setReturnType(ReturnType returnType) {
		this.returnType = returnType;
	}
	public List<FieldError> getFieldErrorList() {
		return fieldErrorList;
	}
	public void setFieldErrorList(List<FieldError> fieldErrorList) {
		this.fieldErrorList = fieldErrorList;
	}
}
