package com.example.demo.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "photo")
public class Photo extends AbstractPersistable<Long> {

    @Version
    private Integer version;

    private String name;

    private LocalDateTime creationTS;

    private Integer width;

    private Integer height;

//    @Enumerated(EnumType.STRING)
    @Column(length = 1)
    private Orientation orientation;
}
