package Informal.Spring.Non_annotation.Service.Impl;

import Informal.Spring.Non_annotation.Service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public void saveCustomer() {
        System.out.println("保存顾客的选项");
    }
}
