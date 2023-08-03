package cl.lemagnifique.restaurant.model.domain.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CheckList {
    private int id;
    private Order visit;
    private String detail;
    private String status;

}
