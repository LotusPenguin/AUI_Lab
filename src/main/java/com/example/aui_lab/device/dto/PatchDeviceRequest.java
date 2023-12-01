package com.example.aui_lab.device.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode

public class PatchDeviceRequest {
    private String name;
    private String manufacturer;
}
