package com.witcher.excel2sql.userinfo.mapper;

/**
 * @author Alex Mihailov {@literal <avmikhaylov@phoenixit.ru>}.
 */
public class IndexHolder {

    private int indexName;
    private int indexPhone;
    private int indexEmail;
    private int indexCity;
    private int indexMethod;
    private int indexAddress;

    public IndexHolder(int indexName, int indexPhone, int indexEmail,
                       int indexCity, int indexMethod, int indexAddress) {
        this.indexName = indexName;
        this.indexPhone = indexPhone;
        this.indexEmail = indexEmail;
        this.indexCity = indexCity;
        this.indexMethod = indexMethod;
        this.indexAddress = indexAddress;
    }

    public int getIndexName() {
        return indexName;
    }

    public int getIndexPhone() {
        return indexPhone;
    }

    public int getIndexEmail() {
        return indexEmail;
    }

    public int getIndexCity() {
        return indexCity;
    }

    public int getIndexMethod() {
        return indexMethod;
    }

    public int getIndexAddress() {
        return indexAddress;
    }
}
