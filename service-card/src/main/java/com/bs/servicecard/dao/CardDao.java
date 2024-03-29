package com.bs.servicecard.dao;


import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Leo Wang
 * @date 2019/8/28
 */
public interface CardDao {
    Map<String, List> getCardsByAccountId(String accountId);
    String updateCardStatus(String cardId);
    String getStatusByCardId(String cardId);

    boolean addSavingCard(String cardId, String productName, String productCode, String accountNickName, String displayAccountNumber, String currencyCode, String accountClassification, String accountId);
    boolean addCreditCard(String  cardId, String productName, String productCode, String accountNickName, String displayAccountNumber, String currentCode, String accountClassification, Date creditLimitIncreaseStartDate, Date creditLimitIncreaseEndDate, String reasonCode, String accountId);

}

