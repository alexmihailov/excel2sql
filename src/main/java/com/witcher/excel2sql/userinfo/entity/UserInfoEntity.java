package com.witcher.excel2sql.userinfo.entity;

/**
 * @author Alex Mihailov {@literal <avmikhaylov@phoenixit.ru>}.
 */
public class UserInfoEntity {

    private String name;
    private String phone;
    private String email;
    private String city;
    private String deliveryMethod;
    private String deliveryAddress;

    public UserInfoEntity() {
    }

    public UserInfoEntity(String name, String phone, String email, String city,
                          String deliveryMethod, String deliveryAddress) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.deliveryMethod = deliveryMethod;
        this.deliveryAddress = deliveryAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String toString() {
        return "UserInfoEntity{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", deliveryMethod='" + deliveryMethod + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                '}';
    }
}
