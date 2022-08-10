package com.coffee.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.sql.Date;


@Getter
@Setter
@RequiredArgsConstructor
public class BillDto {

    private Integer id;

    private String code;

    private Date creationDate;

    private Boolean isDeleted;
}
