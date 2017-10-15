package com.tihor.practice.model;

/**
 * The type Data.
 */
public class Data {
    /**
     * Key.
     */
    private String key;

    /**
     * Value.
     */
    private String value;

    /**
     * Instantiates a new Data.
     *
     * @param key   the key
     * @param value the value
     */
    public Data(final String key, final String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Gets key.
     *
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets key.
     *
     * @param key the key
     */
    public void setKey(final String key) {
        this.key = key;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(final String value) {
        this.value = value;
    }
}
