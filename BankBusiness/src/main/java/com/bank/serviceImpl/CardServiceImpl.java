package com.bank.serviceImpl;

import com.bank.dao.bean.CardDao;
import com.bank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service(value = "CardService")
public class CardServiceImpl implements CardService {


    private CardDao cardDao;

}
