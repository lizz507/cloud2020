package com.springcloud.entities;

/**
 * @author lizz
 * @date 2020/3/11 13:41
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {

    private Long id;

    private String serial;
}
