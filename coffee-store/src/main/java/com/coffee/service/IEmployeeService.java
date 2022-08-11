package com.coffee.service;



import com.coffee.dto.employe.IEmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    /**
     * Create by TuyenTN
     * Data: 9-8-2022
     * @param pageable
     * @param searchByName
     * @param searchByPhone
     * @param searchByAccount
     * @return
     */
    Page<IEmployeeDTO> getAllEmployee(Pageable pageable, String searchByName, String searchByPhone, String searchByAccount);

    /**
     * Create: TuyenTN
     * Data:9-8-2022
     * @param id
     * @return
     */
    IEmployeeDTO findEmployeeById(Integer id);

    /**
     * Create:TuyenTN
     * Data:9-8-2022
     * @param id
     */
    void deleteEmployeeById(Integer id);



}
