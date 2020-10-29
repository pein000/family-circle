package com.family.circle.api.common.vo.request;

import lombok.Data;

@Data
public class BasePageRequest {

    private Integer pageNum;

    private Integer pageSize;

}