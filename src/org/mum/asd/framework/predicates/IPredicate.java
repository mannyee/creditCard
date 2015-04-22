/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.asd.framework.predicates;

/**
 *
 * @author james
 */
public interface IPredicate<T> {

    public boolean check(T t);
}
