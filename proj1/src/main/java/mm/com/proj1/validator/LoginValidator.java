package mm.com.proj1.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import mm.com.proj1.dto.UserDTO;

@Component
public class LoginValidator implements Validator {


	public boolean supports(Class<?> c) {
		return UserDTO.class.isAssignableFrom(c);
	}

	
	public void validate(Object command, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginName", "field.loginName.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword", "field.userPassword.empty");
		/*
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "field.age.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "field.sex.empty");
		UserDTO usrBean = (UserDTO)command;
		if(!isNumber(usrBean.getAge().trim()))
			errors.rejectValue("age", "field.age.NAN");*/
	}
}
