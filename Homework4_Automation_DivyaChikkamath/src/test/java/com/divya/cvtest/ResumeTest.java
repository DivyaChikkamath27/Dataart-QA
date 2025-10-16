package com.divya.cvtest;

import lombok.Builder;
import lombok.Data;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Data
@Builder
class Resume {
    private String fullName;
    private int age;
    private String address;
    private String email;
    private String qualification;
    private String skills;
    private String phoneNumber;
    private String experience;
    private String linkedinProfile;
}

public class ResumeTest {

    private Resume resume;

    @BeforeClass
    public void initializeResume() {
        resume = Resume.builder()
                .fullName("Divya Veerayya Chikkamath")
                .age(22)
                .address("Bangalore, Karnataka, India")
                .email("divya.chikkamath@example.com")
                .qualification("B.E. in Computer Science and Engineering")
                .skills("Manual Testing, Core Java, SQL, HTML, CSS")
                .phoneNumber("+91 9876543210")
                .experience("Internships in Frontend Development and Data Science")
                .linkedinProfile("linkedin.com/in/divya-chikkamath")
                .build();
    }

    @Test
    public void displayResume() {
        System.out.println("\n----- RESUME INFORMATION -----");
        System.out.println("Full Name     : " + resume.getFullName());
        System.out.println("Age           : " + resume.getAge());
        System.out.println("Address       : " + resume.getAddress());
        System.out.println("Email         : " + resume.getEmail());
        System.out.println("Phone Number  : " + resume.getPhoneNumber());
        System.out.println("Qualification : " + resume.getQualification());
        System.out.println("Experience    : " + resume.getExperience());
        System.out.println("Skills        : " + resume.getSkills());
        System.out.println("LinkedIn      : " + resume.getLinkedinProfile());
        System.out.println("------------------------------\n");
    }

    @AfterClass
    public void verifyResumeFields() {
        assertThat(resume.getFullName()).isNotBlank();
        assertThat(resume.getEmail()).contains("@");
        assertThat(resume.getAge()).isGreaterThan(18);
        assertThat(resume.getQualification()).isNotEmpty();
        assertThat(resume.getPhoneNumber()).startsWith("+91");
        assertThat(resume.getLinkedinProfile()).contains("linkedin");
        System.out.println("✅ Resume verification successful — all key fields are valid!");
    }
}
