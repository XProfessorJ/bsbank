package com.bs.servicefeign.service;

import com.bs.servicefeign.error.CustomerError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-customer", fallback = CustomerError.class)
@CrossOrigin
public interface CustomerService {
    @RequestMapping(value = "/customerDashboard",method = RequestMethod.GET)
    String getCustomer(@RequestParam(value = "token") String token);
}
