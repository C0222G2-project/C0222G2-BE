package com.coffee.dto;


import com.coffee.model.dish.DishType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;


public class DishDto implements Validator {

    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 3, message = "mã số món phải nhiều hơn 3 chữ cái")
    private String code;
    @NotNull
    @Min(value = 5000, message = "giá phải lớn hơn 5000")
    private Double price;

    @NotBlank
    @NotNull
    @Size(min = 5, message = "mã số món phải nhiều hơn 3 chữ cái")
    private String name;
    @NotBlank
    @NotNull
    private String image;

    private Boolean isDeleted;

    //    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Invalid format dob")
    private String creationDate;
    private DishType dishType;

    public DishDto() {
    }

    public DishDto(Integer id, @NotNull @NotBlank @Size(min = 3, message = "mã số món phải nhiều hơn 3 chữ cái") String code, @NotNull @Min(value = 5000, message = "giá phải lớn hơn 5000") Double price, @NotBlank @NotNull @Size(min = 5, message = "mã số món phải nhiều hơn 3 chữ cái") String name, @NotBlank @NotNull String image, Boolean isDeleted, String creationDate, DishType dishType) {
        this.id = id;
        this.code = code;
        this.price = price;
        this.name = name;
        this.image = image;
        this.isDeleted = isDeleted;
        this.creationDate = creationDate;
        this.dishType = dishType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public DishType getDishType() {
        return dishType;
    }

    public void setDishType(DishType dishType) {
        this.dishType = dishType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
