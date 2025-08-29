package com.thinkitive.springboot.thinkitive_spring_boot_project.course.jdbc;
import com.thinkitive.springboot.thinkitive_spring_boot_project.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import  org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcCourseRepository
{
    @Autowired
    private JdbcTemplate springJdbcTemplate;
    private static String Query=
            """
                    insert into course (id,name,author) 
                    values (?,?,?);
                    
            """;

    private static String Query_delete=
            """
                delete from course where id=?
            """;


    private static String Query_selectId=
            """
                select * from  course where id=?
            """;
    public void insert(Course course)
    {
        springJdbcTemplate.update(Query,course.getId(),course.getName(),course.getAuthor());
    }

    public void deleteByeId(long id)
    {
        springJdbcTemplate.update(Query_delete,id);

    }
    public Course selectById(long id)
    {
        return springJdbcTemplate.queryForObject(Query_selectId,new BeanPropertyRowMapper<>(Course.class),id);

    }
}
