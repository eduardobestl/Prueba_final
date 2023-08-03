package cl.lemagnifique.restaurant.model.domain.dto;

import lombok.*;

import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    private int id;
    private Table table;
    private Waiter waiter;
    private Double total;



}
