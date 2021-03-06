package com.kamilbanach.user.VO;

import com.kamilbanach.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseTemplateVO {
    private User user;
    private Department department;
    private List<Address> addressList;
}
