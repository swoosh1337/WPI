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
public class IllegalSurnameException extends Exception {

    /**
     * Creates a new instance of <code>SurnameException</code> without detail
     * message.
     */
    public IllegalSurnameException() {
    }

    /**
     * Constructs an instance of <code>SurnameException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public IllegalSurnameException(String msg) {
        super(msg);
    }
}
