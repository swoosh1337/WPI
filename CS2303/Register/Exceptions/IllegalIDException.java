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
public class IllegalIDException extends Exception {

    /**
     * Creates a new instance of <code>IllegalIDException</code> without detail
     * message.
     */
    public IllegalIDException() {
    }

    /**
     * Constructs an instance of <code>IllegalIDException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public IllegalIDException(String msg) {
        super(msg);
    }
}
