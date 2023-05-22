package rog.sziit.dynamicplus.models;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author:poboking
 * @version:1.0
 * @time:2023/5/21 20:45
 */
@Getter
@Setter
@ToString
public class DataSourceEntity extends Model {
    private String jdbcUrl;
    private String password;
    private String name;
    private String driverClassName;
    private String poolName;
}
