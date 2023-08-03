package cl.lemagnifique.restaurant.model.domain.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Table {
  private int id;
  private String number;
  private String capacity;
  private String location;
}
