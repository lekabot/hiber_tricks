package jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
public class Bid {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long amount;
  @ManyToOne(fetch = FetchType.LAZY)
  private Item item;
}
