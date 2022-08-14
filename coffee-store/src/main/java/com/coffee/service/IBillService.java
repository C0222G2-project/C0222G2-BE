package com.coffee.service;

import com.coffee.dto.IBillDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBillService {

    /**
     Created by: HauLT
     * Date created: 09/08/2022
     * function: Show bill list, with pagination,search by bill number and creation date
     *
     * @param pageable
     * @param searchCode
     * @param searchDate
     * @return
     */
    Page<IBillDto> getAll(Pageable pageable, String searchCode, String searchDate);

    /**
     * Created by: HauLT
     * Date created: 09/08/2022
     * function: show bill details by id
     *
     * @param id
     * @return
     */

    IBillDto findById(Integer id);
}
