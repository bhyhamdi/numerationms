package com.numeration.entities;

import com.numeration.enums.CriteriaType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Builder(toBuilder = true)
@Getter
@Setter
@Table(name = "criteria")
@NoArgsConstructor
@AllArgsConstructor
public class Criteria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Integer sortOrder;
    private CriteriaType type;
    private String name;
    private String format;
    private String prefix;
    private String suffix;
}
