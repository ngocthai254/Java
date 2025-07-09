package com.web_hienmau.bai_nhom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "ndung")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Userclass {

    @Id
    private String soDienThoai; // KHÓA CHÍNH

    private String username;

    private String email;

    private String password;
}