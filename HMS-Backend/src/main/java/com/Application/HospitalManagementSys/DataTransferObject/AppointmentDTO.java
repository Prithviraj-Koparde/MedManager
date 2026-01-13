package com.Application.HospitalManagementSys.DataTransferObject;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {

    private Long id;

    @NotBlank(message = "Name is required!")
    private String name;

    @NotBlank(message = "Age is required!")
    @Min(value = 0, message = "Age cannot be negative!")
    private String age;

    @NotBlank(message = "Symptoms are required!")
    private String symptoms;

    @NotBlank(message = "Contact number is required!")
    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Invalid contact number!")
    private String contactNumber;
}
