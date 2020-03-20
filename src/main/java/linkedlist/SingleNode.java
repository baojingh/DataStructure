package linkedlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: hebj
 * @Date: 2020/3/19 20:38
 * @Description:
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SingleNode {

    private SingleNode next;
    private int data;
}
