/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author user_2
 */
public class IllegalDateException extends Exception {

    /**
     * Creates a new instance of <code>IllegalDateException</code> without
     * detail message.
     */
    public IllegalDateException() {
    }

    /**
     * Constructs an instance of <code>IllegalDateException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public IllegalDateException(String msg) {
        super(msg);
    }
}
