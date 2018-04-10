//package controllers.users;
//
//import com.avaje.ebean.annotation.Transactional;
//import com.payAm.core.ebean.BaseDao;
//import com.payAm.core.ebean.RestController;
//import daos.users.OrganizationDao;
//import dtos.users.OrganizationView;
//import models.users.OrganizationEntity;
//import play.mvc.Result;
//
//import javax.inject.Inject;
//
///**
// * Developer: Payam Mostafaei
// * Creation Time: 2017/Jun/03 - 11:25
// */
//public class OrganizationController extends
//        RestController<OrganizationEntity, Long, OrganizationView> {
//
//    @Inject
//    private OrganizationDao dao;
//
//    @Override
//    public BaseDao<Long, OrganizationEntity> getDao() {
//        return dao;
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.ORGANIZATION_UPDATE)
//    public Result insert() {
//        return super.insert();
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.ORGANIZATION_UPDATE)
//    public Result update() {
//        return super.update();
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.ORGANIZATION_DELETE)
//    public Result delete(Long id) {
//        return super.delete(id);
//    }
//}