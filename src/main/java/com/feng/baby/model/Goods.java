package com.feng.baby.model;

import com.feng.baby.support.persistence.IdentifiedDomainObject;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@EqualsAndHashCode(callSuper = false)
@ToString
@Table(name = "goods")
@Accessors(fluent = true)
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Goods extends IdentifiedDomainObject {

    private String name;
    private String size;

    @Column(updatable = false, insertable = false, nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Instant createdAt;

}
