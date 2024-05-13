package com.etiyacrm.common.utilities.results;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataResult<T> {
    private T data;
    private boolean success;
    private String message;

}