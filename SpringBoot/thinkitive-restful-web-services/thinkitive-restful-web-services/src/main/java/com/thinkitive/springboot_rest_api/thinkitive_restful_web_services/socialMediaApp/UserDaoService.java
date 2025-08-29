package com.thinkitive.springboot_rest_api.thinkitive_restful_web_services.socialMediaApp;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Component
public class UserDaoService
{

    private static List<User> users=new ArrayList<User>();
    private static int userCount=0;

    static
    {
        users.add(new User(++userCount,"Chetan", LocalDate.now().minusYears(22)));
        users.add(new User(++userCount,"Pallavi", LocalDate.now().minusYears(22)));
        users.add(new User(++userCount,"Pallavi", LocalDate.now().minusYears(20)));
    }


    public List<User> finAll()
    {
        return users;
    }

    public User findUser(int id)
    {
        User user1;

        for(User user :users)
        {
            if(user.getId()==id)
            {
                return user;
            }
        }
        return null;
    }

    public User save(User user)
    {
        user.setId(++userCount);
        users.add(user);
        return user;

    }

    public User deleteByUserId(int id)
    {
        User user1;

        for(User user :users)
        {
            if(user.getId()==id)
            {
                users.remove(user);
                return user;
            }
        }
        return null;

    }
}
