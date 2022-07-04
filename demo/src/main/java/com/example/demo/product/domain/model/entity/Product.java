package com.example.demo.product.domain.model.entity;

import com.example.demo.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "product")
public class Product extends AuditModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull
        @NotBlank
        private String name;

        @NotNull
        private Integer stock;

        @NotNull
        private Float price;

}
