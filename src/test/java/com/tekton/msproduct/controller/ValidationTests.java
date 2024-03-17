package com.tekton.msproduct.controller;

import com.tekton.msproduct.models.ProductDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationTests {
@Test
@DisplayName("When product name is null, there is 1 validation error")
void nameValidationFailsTest() {

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    Set<ConstraintViolation<ProductDTO>> violations = validator.validate(ProductDTO.builder()
            //.id(1L)
            .price(100.0f)
            .stock(10)
            //.name("name")
            .description("description very very long field so that has more than 50 characters")
            .build());

    assertEquals(1, violations.size());
}

    @Test
    @DisplayName("When description name is null, there is 1 validation error")
    void descriptionValidationFailsTest() {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<ProductDTO>> violations = validator.validate(ProductDTO.builder()
                //.id(1L)
                .price(100.0f)
                .stock(10)
                .name("name")
                .build());

        assertEquals(1, violations.size());
    }

    @Test
    @DisplayName("When id exists in the input object, there is 1 validation error")
    void nullIdValidationFailsTest() {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<ProductDTO>> violations = validator.validate(ProductDTO.builder()
                .id(1L)
                .price(100.0f)
                .stock(10)
                .name("name")
                .description("description very very long field so that has more than 50 characters")
                .build());

        assertEquals(1, violations.size());
    }

    @Test
    @DisplayName("When description is higher than 200 characters, there is 1 validation error")
    void descriptionMaxLengthIdValidationFailsTest() {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<ProductDTO>> violations = validator.validate(ProductDTO.builder()
                .price(100.0f)
                .stock(10)
                .name("name")
                .description("description very very long field so that has more than 50 characters description very very long field so that has more than 50 characters description very very long field so that has more than 50 characters")
                .build());

        assertEquals(1, violations.size());
    }

    @Test
    @DisplayName("When description is less than 50 characters, there is 1 validation error")
    void descriptionMinLengthIdValidationFailsTest() {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<ProductDTO>> violations = validator.validate(ProductDTO.builder()
                .price(100.0f)
                .stock(10)
                .name("name")
                .description("only")
                .build());

        assertEquals(1, violations.size());
    }

    @Test
    @DisplayName("When name is less than 4 characters, there is 1 validation error")
    void nameMinLengthIdValidationFailsTest() {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<ProductDTO>> violations = validator.validate(ProductDTO.builder()
                .price(100.0f)
                .stock(10)
                .name("na")
                .description("description very very long field so that has more than 50 characters")
                .build());

        assertEquals(1, violations.size());
    }

    @Test
    @DisplayName("When name is less than 4 characters, there is 1 validation error")
    void nameMaxLengthIdValidationFailsTest() {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<ProductDTO>> violations = validator.validate(ProductDTO.builder()
                .price(100.0f)
                .stock(10)
                .name("veeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeery loooooooooooooooooooooooooooooooooong naaaaaaaaaaaaaaaaaaaameeeeeeeeeeeeeee")
                .description("description very very long field so that has more than 50 characters")
                .build());

        assertEquals(1, violations.size());
    }

}
