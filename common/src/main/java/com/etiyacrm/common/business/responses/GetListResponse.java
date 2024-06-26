package com.etiyacrm.common.business.responses;

import com.etiyacrm.common.business.paging.PageInfoResponse;

import java.util.ArrayList;
import java.util.List;

public class GetListResponse<T> extends PageInfoResponse {
    private List<T> _items;

    public List<T> getItems() {
        if (_items == null) {
            _items = new ArrayList<>();
        }
        return _items;
    }

    public void setItems(List<T> items) {
        _items = items;
    }
}
