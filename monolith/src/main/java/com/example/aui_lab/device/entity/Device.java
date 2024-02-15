package com.example.aui_lab.device.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "devices")
public class Device implements Serializable {
    @Id
    private UUID id;
    @Column
    private String name;
    @Column
    private String manufacturer;
    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;
}
