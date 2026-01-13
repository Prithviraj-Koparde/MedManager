package com.Application.HospitalManagementSys.DataTransferObject;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {

    private Long id;

    @NotNull(message = "Name is required!")
    private String name;

    @NotNull(message = "Age is required!")
    @Min(value = 0, message = "Age cannot be negative!")
    private String age;

    @NotNull(message = "Symptoms are required!")
    private String symptoms;

    @NotNull(message = "Contact number is required!")
    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Invalid contact number!")
    private String contactNumber;
}
