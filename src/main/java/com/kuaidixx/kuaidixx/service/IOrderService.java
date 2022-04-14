package com.kuaidixx.kuaidixx.service;

import com.kuaidixx.kuaidixx.utils.serverResponse;

public interface orderService {
    public serverResponse findOrderBySendPhone(String phone);
}
