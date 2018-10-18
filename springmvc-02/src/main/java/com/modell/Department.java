package com.modell;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author: San Jinhong
 * date: 2018/9/26 14:25
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private Integer id;
    private String departName;
}
