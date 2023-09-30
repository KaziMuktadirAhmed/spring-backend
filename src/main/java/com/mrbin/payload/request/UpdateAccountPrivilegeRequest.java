package com.mrbin.payload.request;

import com.mrbin.models.EStates.EAccountState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAccountPrivilegeRequest {
    private String requestId;
    private String privilegeType;
    private EAccountState accountState;
}
