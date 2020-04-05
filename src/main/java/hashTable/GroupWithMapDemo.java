package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: hebj
 * @Date: 2020/4/5 14:52
 * @Description:
 */
public class GroupWithMapDemo {

    /**
     * 输入数据：
     * [
     * {"id":hebj,"name":"何保敬","department":"大数据部门"},
     * {"id":bob,"name":"鲍勃","department":"研发部"},
     * {"id":sucy,"name":"苏息","department":"大数据部门"}
     * ]
     * 输出数据
     * [
     * {"department":"大数据部门", "user_list":[{"id":hebj,"name":"何保敬"}, {"id":sucy,"name":"苏息"}]},
     * {"department":"研发部", "user_list":[{"id":bob,"name":"鲍勃"}]}
     * ]
     *
     * @return
     */
    public Map<String, String> groupWithMap(Map<String, String> user_info) {
        Map<String, String> user_group = new HashMap<>();
        for (Map.Entry<String, String> user : user_info.entrySet()) {
            System.out.println(user);
        }


        return user_group;
    }

    public static void main(String[] args) {
        

        Map<String, String> user_group = new HashMap<>();
    }


}
