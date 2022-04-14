package com.kuaidixx.kuaidixx.pojo;

public class user_adress {
    private int id;
    private int user_id;
    private String recipients_full_address;
    private String recipients_province;
    private String recipients_district;
    private String recipients_zip;
    private String recipients_mobile;
    private String recipients_name;
    private String send_full_address;
    private String send_province;
    private String send_district;
    private String send_zip;
    private String sender_mobile;
    private String sender_name;
    private String create_time;
    private String update_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getRecipients_full_address() {
        return recipients_full_address;
    }

    public void setRecipients_full_address(String recipients_full_address) {
        this.recipients_full_address = recipients_full_address;
    }

    public String getRecipients_province() {
        return recipients_province;
    }

    public void setRecipients_province(String recipients_province) {
        this.recipients_province = recipients_province;
    }

    public String getRecipients_district() {
        return recipients_district;
    }

    public void setRecipients_district(String recipients_district) {
        this.recipients_district = recipients_district;
    }

    public String getRecipients_zip() {
        return recipients_zip;
    }

    public void setRecipients_zip(String recipients_zip) {
        this.recipients_zip = recipients_zip;
    }

    public String getRecipients_mobile() {
        return recipients_mobile;
    }

    public void setRecipients_mobile(String recipients_mobile) {
        this.recipients_mobile = recipients_mobile;
    }

    public String getRecipients_name() {
        return recipients_name;
    }

    public void setRecipients_name(String recipients_name) {
        this.recipients_name = recipients_name;
    }

    public String getSend_full_address() {
        return send_full_address;
    }

    public void setSend_full_address(String send_full_address) {
        this.send_full_address = send_full_address;
    }

    public String getSend_province() {
        return send_province;
    }

    public void setSend_province(String send_province) {
        this.send_province = send_province;
    }

    public String getSend_district() {
        return send_district;
    }

    public void setSend_district(String send_district) {
        this.send_district = send_district;
    }

    public String getSend_zip() {
        return send_zip;
    }

    public void setSend_zip(String send_zip) {
        this.send_zip = send_zip;
    }

    public String getSender_mobile() {
        return sender_mobile;
    }

    public void setSender_mobile(String sender_mobile) {
        this.sender_mobile = sender_mobile;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "user_address{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", recipients_full_address='" + recipients_full_address + '\'' +
                ", recipients_province='" + recipients_province + '\'' +
                ", recipients_district='" + recipients_district + '\'' +
                ", recipients_zip='" + recipients_zip + '\'' +
                ", recipients_mobile='" + recipients_mobile + '\'' +
                ", recipients_name='" + recipients_name + '\'' +
                ", send_full_address='" + send_full_address + '\'' +
                ", send_province='" + send_province + '\'' +
                ", send_district='" + send_district + '\'' +
                ", send_zip='" + send_zip + '\'' +
                ", sender_mobile='" + sender_mobile + '\'' +
                ", sender_name='" + sender_name + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
