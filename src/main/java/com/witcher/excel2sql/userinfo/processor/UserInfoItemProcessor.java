package com.witcher.excel2sql.userinfo.processor;

import com.witcher.excel2sql.userinfo.entity.UserInfoEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * @author Alex Mihailov {@literal <avmikhaylov@phoenixit.ru>}.
 */
public class UserInfoItemProcessor implements ItemProcessor<UserInfoEntity, UserInfoEntity> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoItemProcessor.class);

    @Override
    public UserInfoEntity process(UserInfoEntity item) {
        final String name = item.getName();
        final String email = item.getEmail();
        final String phone = item.getPhone();
        final String city = item.getCity();
        final String method = item.getDeliveryMethod();
        final String address = item.getDeliveryAddress();

        final UserInfoEntity transformUserInfo = new UserInfoEntity(
                name, email, phone, city,
                method, address
        );

        LOGGER.info("Converting (" + item + ") into (" + transformUserInfo + ")");

        return transformUserInfo;
    }
}
