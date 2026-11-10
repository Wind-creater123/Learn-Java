package ProxyDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Star implements StarService {
    private String name;

    @Override
    public void sing(String name) {
        System.out.println(this.name+" sing:"+name);
    }

    @Override
    public String dance() {
        System.out.println(this.name+":dance");
        return "dance";
    }
}
