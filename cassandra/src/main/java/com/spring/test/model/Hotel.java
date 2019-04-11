package com.spring.test.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

@Table("hotels")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel implements Serializable {
    private static final long serialVersionUID = 1L;

    @PrimaryKey
    private UUID id;

    private String name;
    private String address;
    private String zip;
    private Integer version;

    public Hotel(String name) {
        this.name = name;
    }

}
