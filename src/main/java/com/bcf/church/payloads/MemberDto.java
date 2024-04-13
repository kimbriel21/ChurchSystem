package com.bcf.church.payloads;

import lombok.Data;

import java.util.Date;

@Data
public class MemberDto {
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthday;
}
