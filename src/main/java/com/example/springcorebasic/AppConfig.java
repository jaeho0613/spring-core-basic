package com.example.springcorebasic;

import com.example.springcorebasic.discount.DiscountPolicy;
import com.example.springcorebasic.discount.RateDiscountPolicy;
import com.example.springcorebasic.member.MemberRepository;
import com.example.springcorebasic.member.MemberService;
import com.example.springcorebasic.member.MemberServiceImpl;
import com.example.springcorebasic.member.MemoryMemberRepository;
import com.example.springcorebasic.order.OrderService;
import com.example.springcorebasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
