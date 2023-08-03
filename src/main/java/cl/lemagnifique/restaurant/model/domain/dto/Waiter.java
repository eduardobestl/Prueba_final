package cl.lemagnifique.restaurant.model.domain.dto;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Waiter {
  private int id;
  private String rut;
  private String name;
  private int age;
  private Date date;
}
