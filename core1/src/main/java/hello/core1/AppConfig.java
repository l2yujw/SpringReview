package hello.core1;


import hello.core1.discount.DiscountPolicy;
import hello.core1.discount.FixDiscountPolicy;
import hello.core1.discount.RateDiscountPolicy;
import hello.core1.member.MemberRepository;
import hello.core1.member.MemberService;
import hello.core1.member.MemberServiceImpl;
import hello.core1.member.MemoryMemberRepository;
import hello.core1.order.OrderService;
import hello.core1.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
