/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.asd.framework.predicates;


/**
 *
 * @author Raj
 */
public class Person500DepositPredicate implements IPredicate<Double> {

    @Override
    public boolean check(Double t) {
        return t > 500;
    }

}
