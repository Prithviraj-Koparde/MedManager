package com.Application.HospitalManagementSys.DataTransferObject;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicineDTO {

    private Long id;

    @NotNull(message = "Drug name is required!")
    private String drugName;

    @NotNull(message = "Stock is required!")
    @Min(value = 0, message = "Stock cannot be negative")
    private String stock;
}
