package com.mrbin.payload.request;

import com.mrbin.models.EStates.EAccountState;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class UpdateAccountPrivilegeRequest {
    private String privilegeType;
    private EAccountState accountState;
}
