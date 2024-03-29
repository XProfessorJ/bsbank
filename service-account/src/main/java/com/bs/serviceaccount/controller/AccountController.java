package com.bs.serviceaccount.controller;


import com.bs.serviceaccount.entity.AccountEntity;
import com.bs.serviceaccount.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/account/{id}", produces = {"application/json"})
    @ResponseBody
    public Map<String, Object> getAccount(@PathVariable("id") String id) {
        Map<String, Object> resultMap = new HashMap<>();
        AccountEntity account = accountService.findAccountByAccountId(id);
        resultMap.put("account", account);
        return resultMap;
    }

}
