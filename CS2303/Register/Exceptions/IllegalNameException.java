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
public class IllegalNameException extends Exception {

    /**
     * Creates a new instance of <code>NameException</code> without detail
     * message.
     */
    public IllegalNameException() {
    }

    /**
     * Constructs an instance of <code>NameException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public IllegalNameException(String msg) {
        super(msg);
    }
}
