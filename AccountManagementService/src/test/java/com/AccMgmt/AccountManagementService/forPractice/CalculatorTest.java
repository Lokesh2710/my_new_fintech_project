package com.AccMgmt.AccountManagementService.forPractice;
import com.AccMgmt.AccountManagementService.justForPractiseJnuitCoreJava.Calculator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Disabled
    @Test
    public void testDoSum() {
        assertThat(10).isEqualTo(calculator.doSum(2, 3,5));
    }
    @Test
    public void TestDoProduct(){
        assertThat(6).isEqualTo(calculator.doProduct(2, 3));
    }
    @Test
    public void TestComare(){
        //assertThat(true).isEqualTo(calculator.compareNum(2, 2));
        assertThat(calculator.compareNum(2, 2)).isTrue();

    }
}
