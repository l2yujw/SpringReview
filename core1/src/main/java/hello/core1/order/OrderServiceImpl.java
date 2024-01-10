package hello.core1.order;

import hello.core1.annotation.MainDiscountPolicy;
import hello.core1.discount.DiscountPolicy;
import hello.core1.member.Member;
import hello.core1.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired //생략 가능
    public OrderServiceImpl(MemberRepository memberRepository,@MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
//        System.out.println("memberRepository = " + memberRepository + ", discountPolicy = " + discountPolicy);
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    /**
     * 테스트 용도
     */
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
