//package controllers.users;
//
//import com.avaje.ebean.annotation.Transactional;
//import com.payAm.core.ebean.BaseDao;
//import com.payAm.core.ebean.RestController;
//import daos.users.RoleDao;
//import dtos.users.RoleView;
//import models.users.RoleEntity;
//import play.mvc.Result;
//
//import javax.inject.Inject;
//
///**
// * Developer: Payam Mostafaei
// * Creation Time: 2017/Jun/03 - 11:25
// */
//public class RoleController extends
//        RestController<RoleEntity, Long, RoleView> {
//
//    @Inject
//    private RoleDao dao;
//
//    @Override
//    public BaseDao<Long, RoleEntity> getDao() {
//        return dao;
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.ROLE_UPDATE)
//    public Result insert() {
//        return super.insert();
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.ROLE_UPDATE)
//    public Result update() {
//        return super.update();
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.ROLE_DELETE)
//    public Result delete(Long id) {
//        return super.delete(id);
//    }
//}