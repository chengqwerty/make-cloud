package som.cloud.make.well.user.web.data.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import som.cloud.make.well.user.web.data.pojo.User;

@Mapper
@Repository
public interface UserDao {

    @Select("select * from tb_user where id = #{id}")
    User findById(@Param("id") Long id);
}
