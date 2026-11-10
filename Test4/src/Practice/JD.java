package Practice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JD implements Switch {
    private String name;
    private boolean status;

    @Override
    public void switchStatus() {
        status=!status;
    }
}
