package com.example.aui_lab.device.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutDeviceRequest {
    private String name;
    private String manufacturer;
    private UUID category;
}
