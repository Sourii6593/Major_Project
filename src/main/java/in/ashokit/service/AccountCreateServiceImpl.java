package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.UserEntity;
import in.ashokit.repo.UserRepository;
import in.ashokit.util.EmailUtils;
import in.ashokit.util.PwdUtil;

@Service
public class AccountCreateServiceImpl implements AccountCreateService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	EmailUtils emailUtils;
	@Autowired
	PwdUtil pwdUtil;

	@Override
	public boolean accountSave(UserEntity userEntity) {
		//UserEntity entity =new UserEntity();
		//BeanUtils.copyProperties(userEntity, entity);
		  
         String tempPwd = pwdUtil.generateRandomPwd();		
         
         userEntity.setAccStatus("LOCKED");
         userEntity.setTempPwd(tempPwd);
         
         userRepository.save(userEntity);
		
		String to = userEntity.getUemail();
	     String subject = "UNLOCK YOUR ACCOUNT";
	     StringBuffer body = new StringBuffer(" ");
	     body.append("<h1>Use below temporary PWD to Unlock Your Account</h1>");
	     
	     body.append("Temporary Password: "+tempPwd);
	     
	     body.append(" ");
	     body.append("\n");
	     
	     body.append("<a href=\"http:localhost:8090/unlock?email="+to+"\">Click Here To Unlock Your Account</a>");
	     
	     emailUtils.sendEmail(to, subject, body.toString());
	    
		return true;
	}

	@Override
	public List<UserEntity> getAllAccount() {
		//List<UserEntity> getAllAcoount = userRepository.findAll();
		//return getAllAcoount;
		return userRepository.findAll();
	}

	 @Override
	 public UserEntity getById(Integer uid) {  
		 Optional<UserEntity> findById = userRepository.findById(uid);
		 return findById.get();
	 }
	 
	
	 
	
}
