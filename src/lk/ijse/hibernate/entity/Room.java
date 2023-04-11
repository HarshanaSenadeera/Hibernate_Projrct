package lk.ijse.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
/**
 * @author : Harshana Senadeera
 * @since : 0.1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {

    private String room_id;
    private String type;
    private String key_money;
    private int qty;

    @OneToMany(mappedBy = "room_type_id", fetch = FetchType.EAGER)
    private List<Reservation> roomDetails = new ArrayList<>();


}
