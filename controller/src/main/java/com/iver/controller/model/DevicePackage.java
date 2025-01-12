package com.iver.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "device-packages")
public class DevicePackage {
    @Id
    private String id;
    private OffsetDateTime createdAt = OffsetDateTime.now();
}
