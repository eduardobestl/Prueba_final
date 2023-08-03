package cl.lemagnifique.restaurant.model.domain.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Pay {
    private int id;
    private Date payDay;
    private float amount;
    private Waiter waiter;


}
