package som.cloud.make.well.order.web.data.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import som.cloud.make.well.order.web.data.pojo.Order;

@Mapper
@Repository
public interface OrderDao {

    @Select("select * from tb_order where id = #{id}")
    Order findById(Long id);

}
