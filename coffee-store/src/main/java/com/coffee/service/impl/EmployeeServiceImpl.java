package com.coffee.service.impl;

import com.coffee.dto.IEmployeeDTO;
import com.coffee.repository.IEmployeeRepository;
import com.coffee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    /**
     * Create by TuyenTN
     * Date: 9-8-2022 16:37
     * @param pageable
     * @param searchByName
     * @param searchByPhone
     * @param searchByAccount
     * @return
     */
    @Override
    public Page<IEmployeeDTO> getAllEmployee(Pageable pageable, String searchByName, String searchByPhone, String searchByAccount) {
        return iEmployeeRepository.getAllEmployee(pageable,"%"+searchByName+"%","%"+searchByPhone+"%",
                "%"+searchByAccount+"%");
    }

    /**
     * Create by TuyenTN
     * Date: 9-8-2022
     * findEmployeeById(id)
     * @param id
     * @return
     */
    @Override
    public IEmployeeDTO findEmployeeById(Integer id) {
        return this.iEmployeeRepository.findEmployeeById(id);
    }

    /**
     * Create by TuyenTN
     * Date: 9-8-2022
     * deleteEmployeeById()
     * @param id
     */
    @Override
    public void deleteEmployeeById(Integer id) {
        this.iEmployeeRepository.deleteEmployeeById(id);
    }

}
