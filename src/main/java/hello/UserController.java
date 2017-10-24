package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/add")
	public @ResponseBody String addNewUser (@RequestParam String username, @RequestParam String password) {
		User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		userRepository.save(user);
		return "saved";
	}
	
	@RequestMapping("/getAllUser")
	public @ResponseBody String getAllUser() {
		Iterable<User> u = userRepository.findAll();
		JSONArray jsonobj = JSONArray.fromObject(u);
		return jsonobj.toString();
	}
	
	@RequestMapping("/getUserById")
	public @ResponseBody String getUserById(@RequestParam Integer id) {
		User u = userRepository.findOne(id);
		JSONObject jsonobj = JSONObject.fromObject(u);
		return jsonobj.toString();
	}
}
