package com.Application.HospitalManagementSys.DataTransferObject;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicineDTO {

    private Long id;

    @NotBlank(message = "Drug name is required!")
    private String drugName;

    @NotBlank(message = "Stock is required!")
    @Min(value = 0, message = "Stock cannot be negative")
    private String stock;
}
