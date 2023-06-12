package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GradingCalculatorTest {

    private GradingCalculator gradingCalculator;

    @BeforeEach
    void setUp() {
        gradingCalculator = new GradingCalculator();
    }
    @Test
    void testGetGradeWithScore_95_andAttendance_90TheResultShouldBe_A() {
        //gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(90);

        char res = gradingCalculator.getGrade();

        Assertions.assertEquals('A', res);
    }

    @Test
    void testGetGradeWithScore_85_andAttendance_90TheResultShouldBe_B() {
        //gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(85);
        gradingCalculator.setAttendancePercentage(90);

        char res = gradingCalculator.getGrade();

        Assertions.assertEquals('B', res);
    }

    @Test
    void testGetGradeWithScore_65_andAttendance_90TheResultShouldBe_C() {
        //gradingCalculator = new GradingCalculator();
//        gradingCalculator.setScore(65);
//        gradingCalculator.setAttendancePercentage(90);
//
//        char res = gradingCalculator.getGrade();

        char res = arrangeAndAct(65,90);

        Assertions.assertEquals('C', res);
    }

    @Test
    void testGetGradeWithScore_65_andAttendance_90TheResultShouldBe_A() {

        char res = arrangeAndAct(95,65);

        Assertions.assertEquals('B', res);
    }
    //....


    private char arrangeAndAct(int s, int a) {
        gradingCalculator.setScore(s);
        gradingCalculator.setAttendancePercentage(a);
        return gradingCalculator.getGrade();
    }
}
