package in.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.UserEntity;
import in.ashokit.service.AccountCreateService;

@RestController
public class AccountCreateRestController {
	
	@Autowired
	AccountCreateService accountCreateService;
	
	@PostMapping(path= "/accountcreate")
	public String AccountSave(@RequestBody UserEntity userEntity) {
		
		
		accountCreateService.accountSave(userEntity);
		return "Succesfully record saved ";
	}
	
	@GetMapping("/alluser")
	public List<UserEntity> gettAllUser() {
      return  accountCreateService.getAllAccount();
	}
	@PutMapping("/update")
	public UserEntity updateUser(Integer uid) {
		return accountCreateService.getById(uid);
		
	}
}
