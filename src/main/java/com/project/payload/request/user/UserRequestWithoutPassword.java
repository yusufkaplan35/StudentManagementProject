package com.project.payload.request.user;

import com.project.payload.request.abstracts.AbstractUserRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class UserRequestWithoutPassword extends AbstractUserRequest {



}
