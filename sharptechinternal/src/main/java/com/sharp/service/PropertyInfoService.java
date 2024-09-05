package com.sharp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharp.model.PropertyInfo;
import com.sharp.repository.PropertyInfoRepository;

@Service
public class PropertyInfoService {

    @Autowired
    private PropertyInfoRepository propertyInfoRepository;

    /**
     * Finds a PropertyInfo by its order number.
     *
     * @param orderNumber the order number of the PropertyInfo
     * @return the PropertyInfo with the given order number, or null if not found
     */
    public PropertyInfo findByOrderNumber(String orderNumber) {
        return propertyInfoRepository.findByOrderNumber(orderNumber);
    }

    /**
     * Saves or updates a PropertyInfo entity.
     *
     * @param propertyInfo the PropertyInfo entity to save or update
     * @return the saved or updated PropertyInfo entity
     */
    @Transactional
    public PropertyInfo savePropertyInfo(PropertyInfo propertyInfo) {
        return propertyInfoRepository.save(propertyInfo);
    }
    public PropertyInfo save(PropertyInfo propertyInfo) {
        return propertyInfoRepository.save(propertyInfo);
    }
    
    
}
