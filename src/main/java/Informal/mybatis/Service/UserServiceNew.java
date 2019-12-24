package Informal.mybatis.Service;

import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

public interface UserServiceNew {
    Map deleteSome(List<Integer> list);
    String searchOrders(Model model, Integer id);
}
