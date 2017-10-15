package com.tihor.practice.model;

/**
 * The type Error.
 */
public class Error {
    /**
     * Code.
     */
    private Integer code;

    /**
     * Message.
     */
    private String message;

    /**
     * Instantiates a new Error.
     *
     * @param code    the code
     * @param message the message
     */
    public Error(final Integer code, final String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(final Integer code) {
        this.code = code;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(final String message) {
        this.message = message;
    }
}
