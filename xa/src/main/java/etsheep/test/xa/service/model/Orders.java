package etsheep.test.xa.service.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by etsheep on 2019-7-2.
 */

@Entity
@Table(name = "orders")
@Data
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String orderNo;
    private String orderDetail;
    private BigDecimal money;
    private Date createDatetime;
}
