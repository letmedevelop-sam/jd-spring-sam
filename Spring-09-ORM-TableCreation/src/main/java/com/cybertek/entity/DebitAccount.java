package com.cybertek.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity  //means it will be a table
public class DebitAccount extends Account { //add inheritance

    private BigDecimal overDraftFee;
}
