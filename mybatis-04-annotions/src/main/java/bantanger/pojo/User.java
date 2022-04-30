package bantanger.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/23 18:44
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private String password;
}
