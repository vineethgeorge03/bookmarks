package com.demo.bookmarks.testing;

import com.demo.bookmarks.testing.Item;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessService {

    public Item retreiveHardCodedItem() {
        return new Item(1,"Ball",10,100);
    }
}
