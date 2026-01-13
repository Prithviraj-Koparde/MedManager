package com.Application.HospitalManagementSys.DataTransferObject;


import com.Application.HospitalManagementSys.ENUM.Gender;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {

    private Long id;

    @NotBlank(message = "Name is required!")
    private String name;

    @NotBlank(message = "Contact number is required!")
    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Invalid contact number!")
    private String contactNumber;

    @NotBlank(message = "Contact number is required!")
    @Min(value = 0, message = "Age cannot be negative")
    private String age;

    @NotBlank(message = "Gender is required!")
    private Gender gender;

    @NotBlank(message = "Contact number is required!")
    @Pattern(
            regexp = "^(A|B|AB|O)[+-]$",
            message = "Invalid blood group. Allowed values: A+, A-, B+, B-, AB+, AB-, O+, O-"
    )
    private String bloodGroup;

    @NotBlank(message = "Contact number is required!")
    private String dose;

    @NotBlank(message = "Contact number is required!")
    private String prescription;

    @NotBlank(message = "Contact number is required!")
    private String urgency;

    @NotBlank(message = "Contact number is required!")
    @Min(value = 0, message = "Fees cannot be negative")
    private Double fees;
}
