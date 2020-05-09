package com.miu.cs.restfulweb.user;

import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserDaoService {
    static List<User> users = new ArrayList<User>();
    private static int userCount;
    static {
        users.add(new User(0, "Manoj", new Date()));
        users.add(new User(1, "Sibtain", new Date()));
        users.add(new User(2, "Owasis", new Date()));
        userCount = 2;
    }
    List<User> findAll(){
        return users;
    }

    User save(User user){
        if(user.getId()==null)
            user.setId(++userCount);
        users.add(user);
        return users.get(userCount);
    }

    User findUser(int id){
        if(id<=userCount)
            return users.get(id);
        return null;
    }

    User deleteUser(int id){
        for(User user: users) {
            if (user.getId() == id){
                users.remove(user);
                return user;
            }
        }
        return null;
    }
}
