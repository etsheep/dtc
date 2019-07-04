package etsheep.test.lcn.goods.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by etsheep on 2019-7-2.
 */

@Entity
@Table(name = "goods")
@Data
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private BigDecimal money;
    private Integer stock;
}
