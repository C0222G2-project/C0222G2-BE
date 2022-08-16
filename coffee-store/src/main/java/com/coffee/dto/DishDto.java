package com.coffee.dto;
import com.coffee.model.dish.DishType;
import lombok.Data;
import javax.validation.constraints.*;
import java.sql.Date;
@Data
public class DishDto  {
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
    private Date creationDate;
    private DishType dishType;


}
