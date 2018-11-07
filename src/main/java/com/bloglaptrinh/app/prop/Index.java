package com.bloglaptrinh.app.prop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Index {
    private String name;
    private String type;
    private int shard;
    private int replica;
    private int from;
    private int size;
    private int timeout;
}
