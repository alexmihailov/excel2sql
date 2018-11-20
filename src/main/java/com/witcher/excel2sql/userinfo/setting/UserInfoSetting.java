package com.witcher.excel2sql.userinfo.setting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Alex Mihailov {@literal <avmikhaylov@phoenixit.ru>}.
 */

@Component
public class UserInfoSetting {

    @Value("${setting.input.file}")
    private String inputFile;

    @Value("${setting.input.line.skip.count}")
    private int skipRows;

    @Value("${setting.output.file}")
    private String outputFile;

    @Value("${setting.output.line.format}")
    private String formatLine;

    @Value("${setting.output.line.separator}")
    private String separatorLine;

    @Value("${setting.index.name}")
    private int indexName;

    @Value("${setting.index.phone}")
    private int indexPhone;

    @Value("${setting.index.email}")
    private int indexEmail;

    @Value("${setting.index.city}")
    private int indexCity;

    @Value("${setting.index.method}")
    private int indexDeliveryMethod;

    @Value("${setting.index.address}")
    private int indexDeliveryAddress;

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

    public int getIndexDeliveryMethod() {
        return indexDeliveryMethod;
    }

    public int getIndexDeliveryAddress() {
        return indexDeliveryAddress;
    }

    public String getInputFile() {
        return inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public String getFormatLine() {
        return formatLine;
    }

    public String getSeparatorLine() {
        return separatorLine;
    }

    public int getSkipRows() {
        return skipRows;
    }
}
