package com.kai.chap.dao;

import com.kai.chap.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 用户dao接口
 * <p>
 *     JpaRepository（继承这个类，则系统会默认帮我们实现操作方法）
 * </p>
 */
public interface UserDao extends JpaRepository<User, Long> {

    /**
     * 根据单个属性模糊查询
     * <p>
     *     这里命名是以动词（get/find）开始的，而以by代表按照什么内容进行查询，
     *     这样JPA就会根据方法名生成SQL来查询数据库了
     * </p>
     * @param userName
     * @return
     */
    List<User> findByUserNameLike(String userName);

    /**
     * 根据多个个属性模糊查询
     * <p>
     *     这里命名是以动词（get/find）开始的，而以by代表按照什么内容进行查询，
     *     两个属性之间以Or连接，这样sql也就生成or将两个属性关联起来，
     *     这样JPA就会根据方法名生成SQL来查询数据库了
     * </p>
     * @param userName
     * @return
     */
    List<User> findByUserNameLikeOrNoteLike(String userName, String note);

    /**
     * 自己重新命名一个根据Id查询用户对象的接口
     * <p>
     *     命名规则依旧按照以动词开始（get/find）,会自动生成sql
     * </p>
     * @param id
     * @return
     */
    User getUserById(Long id);

}
