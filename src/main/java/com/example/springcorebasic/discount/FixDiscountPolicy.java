package com.example.springcorebasic.discount;

import com.example.springcorebasic.member.Grade;
import com.example.springcorebasic.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    
    private int discountFixAmount = 1000; // 10000원 할인
    
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
