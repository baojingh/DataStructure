package hashTable.GroupWithmapDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
     * {"id":bob","name":"hbj","departmentName":"bd"},
     * {"id":tom","name":"hello","departmentName":"rd"},
     * {"id":"alex","name":"alexander","departmentName":"rd"},
     * {"id":"tom","name":"Thomas","departmentName":"bd"},
     * ]
     * 输出数据
     * [
     * {"department":"bd", "user_list":[{"id":"bob","name":"hebj","departmentName":"bd"},
     * {"id":"bob","name":"hebj","departmentName":"bd"},]},
     * {"department":"bd", "user_list":[{"id":"bob","name":"hebj","departmentName":"bd"},
     * {"id":"bob","name":"hebj","departmentName":"bd"},]},
     * ]
     *
     * @return
     */
    public Map<String, List<UserInfo>> groupWithMap(ArrayList<UserInfo> userList) {
        HashMap<String, List<UserInfo>> departmentUserListMap = new HashMap<>();
        for (UserInfo userInfo : userList) {
            String departmentName = userInfo.getDepartmentName();
            List<UserInfo> userInfoList = departmentUserListMap.get(departmentName);
            if (userInfoList == null) {
                userInfoList = new ArrayList<>();
            }
            userInfoList.add(userInfo);
            departmentUserListMap.put(departmentName, userInfoList);
        }
        return departmentUserListMap;
    }

    public static void main(String[] args) {

        UserInfo userInfo1 = new UserInfo("bob", "hebaojing", "bd");
        UserInfo userInfo2 = new UserInfo("sucy", "bigdog", "rd");
        UserInfo userInfo3 = new UserInfo("tom", "Thomas", "rd");
        UserInfo userInfo4 = new UserInfo("alex", "alexander", "bd");
        ArrayList<UserInfo> mapArrayList = new ArrayList<>();
        mapArrayList.add(userInfo1);
        mapArrayList.add(userInfo2);
        mapArrayList.add(userInfo3);
        mapArrayList.add(userInfo4);

        GroupWithMapDemo mapDemo = new GroupWithMapDemo();
        Map<String, List<UserInfo>> stringListMap = mapDemo.groupWithMap(mapArrayList);
        for (Map.Entry entry : stringListMap.entrySet()) {
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }
    }


}
