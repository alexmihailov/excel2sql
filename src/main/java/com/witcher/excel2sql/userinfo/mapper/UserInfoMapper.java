package com.witcher.excel2sql.userinfo.mapper;

import com.witcher.excel2sql.userinfo.entity.UserInfoEntity;
import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.support.rowset.RowSet;

/**
 * @author Alex Mihailov {@literal <avmikhaylov@phoenixit.ru>}.
 */

public class UserInfoMapper implements RowMapper<UserInfoEntity> {

    private IndexHolder mIndexHolder;

    public UserInfoMapper(IndexHolder indexHolder) {
        mIndexHolder = indexHolder;
    }

    @Override
    public UserInfoEntity mapRow(RowSet rowSet) {
        UserInfoEntity userInfoEntity = new UserInfoEntity();

        userInfoEntity.setName(rowSet.getColumnValue(mIndexHolder.getIndexName()));
        userInfoEntity.setPhone(rowSet.getColumnValue(mIndexHolder.getIndexPhone()));
        userInfoEntity.setEmail(rowSet.getColumnValue(mIndexHolder.getIndexEmail()));
        userInfoEntity.setCity(rowSet.getColumnValue(mIndexHolder.getIndexCity()));
        userInfoEntity.setDeliveryMethod(rowSet.getColumnValue(mIndexHolder.getIndexMethod()));
        userInfoEntity.setDeliveryAddress(rowSet.getColumnValue(mIndexHolder.getIndexAddress()));

        return userInfoEntity;
    }
}
