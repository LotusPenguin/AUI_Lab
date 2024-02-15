package com.example.aui_lab.device.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "categories")
public class Category implements Serializable {
    @Id
    private UUID id;
    @Column
    private String name;
    @Column
    private double packagingPrice;
    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Device> devices = new ArrayList<>();
}
