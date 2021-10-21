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
public class IllegalUserNameException extends Exception {

    /**
     * Creates a new instance of <code>IllegalUSerNameException</code> without
     * detail message.
     */
    public IllegalUserNameException() {
    }

    /**
     * Constructs an instance of <code>IllegalUSerNameException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public IllegalUserNameException(String msg) {
        super(msg);
    }
}
