package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.UserEntity;

public interface AccountCreateService {

	public boolean accountSave(UserEntity userEntity);

	public List<UserEntity> getAllAccount();

	public UserEntity getById(Integer id);

}
