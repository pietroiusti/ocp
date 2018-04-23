/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.AdvancedClassDesign;

/**
 *
 * @author PietroS
 */
public class ReviewQuestionsAdvClassDesign1 {

    public int employeeId;
    public String firstName, lastName;
    public int yearStarted;

    @Override
    public int hashCode() {
        return employeeId;
    }

    public boolean equals(ReviewQuestionsAdvClassDesign1 e) {
        return this.employeeId == e.employeeId;
    }

    public static void main(String[] args) {
        ReviewQuestionsAdvClassDesign1 one = new ReviewQuestionsAdvClassDesign1();
        one.employeeId = 101;
        ReviewQuestionsAdvClassDesign1 two = new ReviewQuestionsAdvClassDesign1();
        two.employeeId = 101;
        if (one.equals(two)) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}

