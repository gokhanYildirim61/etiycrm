package com.etiyacrm.customerservice.core.exceptions.handlers;


import com.etiyacrm.customerservice.core.exceptions.details.BusinessProblemDetails;
import com.etiyacrm.customerservice.core.exceptions.details.ValidationProblemDetails;
import com.etiyacrm.customerservice.core.exceptions.types.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBusinessException(BusinessException businessExceptions){
        BusinessProblemDetails businessProblemDetails = new BusinessProblemDetails();
        businessProblemDetails.setDetail(businessExceptions.getMessage());
        return businessProblemDetails;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(code=HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException exception){

        List<Map<String, String>> validationErrors = new ArrayList<>();

        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            Map<String, String> validationError = new HashMap<>();
            validationError.put("field", fieldError.getField());
            validationError.put("message", fieldError.getDefaultMessage());
            validationErrors.add(validationError);
        });


        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setErrors(validationErrors);
        return validationProblemDetails;    //Dönüş tipi liste olamaz çünkü map tutuyor
    }

}

//arasındaki ilişki aşağıdaki gibi
//Rental branch - city, rental branch - rental
//id si 1 olan araç kiralandı diyebilmeli state hemen değişmeli eğer başkasına kiralanmışsahand
//yeni bir kiralama yapıldığında eski arabanın krialanabilir duruma (Available) state kısmının gelmesi gerekiyopr
//exception türlerini araştırın runtime ve business dışında olanları
//veritabanına bağlanamama - data integrity violation
//INTERNAL_SERVER_ERROR - status kısmı
//@ExceptionHandler({bunu kendin bakacaksın SqlException olabilir, diğerleri hepsine bakman gerekiyor.class})
//internalservererror için bir exception yapısı kurup problemdetails ve handleException metodunu yazarak sisteme dahil edilecek