package com.zhang.biyeseji.remeberme.service;

import com.zhang.biyeseji.remeberme.pojo.Message;
import com.zhang.biyeseji.remeberme.util.PageRequest;
import com.zhang.biyeseji.remeberme.util.PageRequestHasId;
import com.zhang.biyeseji.remeberme.util.PageResult;

public interface MessageService {
    void saveMessage(Message message);

    PageResult selectPageByPageRequest(PageRequestHasId pageRequest);

    void deleteMessageById(Integer id);

    PageResult selectMessageAndUserPage(PageRequest pageRequest);
}
