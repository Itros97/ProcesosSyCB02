package com.util;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class usuario {
    @PrimaryKey
    int id;

    String name;
}
