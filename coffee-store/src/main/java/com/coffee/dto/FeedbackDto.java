package com.coffee.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

/**
 * Created by: DiepTT
 * Date created: 09/08/2022
 * Date updated: 10/08/2022
 * Function: Create feedback (User send feedback)
 */

public class FeedbackDto {

    @NotBlank(message = "Vui lòng nhập họ và tên.")
    @Pattern(regexp = "^([A-ZÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẬẪÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐ]" +
            "[a-záàảãạăắằẳẵặâấầẩậẫéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđ]*" +
            "( ))*([A-ZÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẬẪÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐ]" +
            "[a-záàảãạăắằẳẵặâấầẩậẫéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđ]*)$",
            message = "Vui lòng nhập đúng định dạng họ và tên: " +
                    "viết hoa chữ cái đầu mỗi từ, không chứa ký tự đặc biệt...")
    @Size(min = 2, max = 30, message = "Vui lòng nhập 2 - 30 ký tự.")
    private String creator;

    @NotBlank(message = "Vui lòng nhập địa chỉ email cá nhân.")
    @Email(message = "Vui lòng nhập đúng định dạng email.")
    @Size(min = 5, max = 320, message = "Vui lòng nhập 5 - 320 ký tự.")
    private String email;

    @NotBlank(message = "Vui lòng nhập nội dung phản hồi.")
    @Size(min = 2, message = "Vui lòng nhập nhiều hơn 1 ký tự.")
    private String content;

    @NotNull(message = "Vui lòng đánh giá sao trước khi phản hồi.")
    @Range(min = 1, max = 5, message = "Vui lòng đánh giá 1-5 sao.")
    private Integer rating;

    @NotBlank(message = "Vui lòng đính kèm ảnh phản hồi thực tế.")
    @Size(min = 5, max = 200, message = "Vui lòng đặt tên ảnh từ 5 đến 200 ký tự.")
    private String image;


    public FeedbackDto() {
    }

    public FeedbackDto(String creator, String email, String content, Integer rating, String image) {
        this.creator = creator;
        this.email = email;
        this.content = content;
        this.rating = rating;
        this.image = image;
    }


    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
